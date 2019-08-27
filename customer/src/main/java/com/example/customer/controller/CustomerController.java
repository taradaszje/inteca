package com.example.customer.controller;

import com.example.customer.entity.Customer;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public Customer getCustomer(@RequestParam final UUID creditNumber){
        return this.customerService.getCustomer(creditNumber);
    }

    @PostMapping("/customers")
    public void saveCustomer(@RequestBody final Customer customer){
        this.customerService.saveCustomer(customer);
    }


}
