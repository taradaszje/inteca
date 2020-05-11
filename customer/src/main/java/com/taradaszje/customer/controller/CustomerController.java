package com.taradaszje.customer.controller;

import com.taradaszje.customer.entity.Customer;
import com.taradaszje.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers/{creditID}")
    public Customer getCustomer(@PathVariable final UUID creditID){
        return this.customerService.getCustomer(creditID);
    }

    @PostMapping("/customers")
    public void saveCustomer(@RequestBody final Customer customer){
        this.customerService.saveCustomer(customer);
    }


}
