package com.example.credit.proxies;

import com.example.credit.beans.Product;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;


@FeignClient(name = "product-service")
@RibbonClient(name = "product-service")
public interface ProductServiceProxy {

    @GetMapping("/getProduct/{creditID}")
    public Product getProduct(@PathVariable final UUID creditID);

    @PostMapping("/createProduct")
    public void saveProduct(@RequestBody final Product product);
}

