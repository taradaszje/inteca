package com.example.credit.proxies;

import com.example.credit.beans.Customer;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;


@FeignClient(name = "customer-service")
@RibbonClient(name = "customer-service")
public interface CustomerServiceProxy {

    @GetMapping("/getCustomer/{creditID}")
    public Customer getCustomer(@PathVariable final UUID creditID);

    @PostMapping("/createCustomer")
    public void saveCustomer(@RequestBody final Customer customer);

}