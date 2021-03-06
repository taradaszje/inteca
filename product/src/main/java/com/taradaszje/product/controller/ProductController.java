package com.taradaszje.product.controller;

import com.taradaszje.product.entity.Product;
import com.taradaszje.product.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping("/products/{creditID}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProduct(@PathVariable final UUID creditID){
        return this.productService.getProduct(creditID);
    }

    @PostMapping(value = "/products",consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProduct(@RequestBody final Product product){
        productService.saveProduct(product);
    }
}
