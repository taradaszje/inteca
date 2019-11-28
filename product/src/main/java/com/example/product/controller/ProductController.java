package com.example.product.controller;

import com.example.product.entity.Product;
import com.example.product.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping("/getProduct/{creditID}")
    public Product getProduct(@PathVariable final UUID creditID){
        return this.productService.getProduct(creditID);
    }

    @PostMapping(value = "/createProduct",consumes = "application/json")
    public void saveProduct(@RequestBody final Product product){
        productService.saveProduct(product);
    }
}
