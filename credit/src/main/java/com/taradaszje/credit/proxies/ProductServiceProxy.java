package com.taradaszje.credit.proxies;

import com.taradaszje.credit.beans.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;


@FeignClient(name = "product-service", url = "192.168.99.100:8080/ps")
public interface ProductServiceProxy {

    @GetMapping("/products/{creditID}")
    Product getProduct(@PathVariable(name = "creditID") final UUID creditID);

    @PostMapping("/products")
    void saveProduct(@RequestBody final Product product);
}

