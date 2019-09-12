package com.example.product.controller;

import com.example.product.entity.Product;
import com.example.product.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/products")
    public Product getProduct(@RequestParam final UUID creditNumber){
        return this.productService.getProducts(creditNumber);
    }

    @PostMapping(value = "/products",consumes = "application/json")
    public void saveProduct(@RequestBody final Product product){
        productService.saveProduct(product);
    }
}
