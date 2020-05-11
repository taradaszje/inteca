package com.taradaszje.credit.proxies;

import com.taradaszje.credit.beans.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;


@FeignClient(name="customer-service", url = "192.168.99.100:8080/cs")
public interface CustomerServiceProxy {

    @GetMapping("/customers/{creditID}")
    Customer getCustomer(@PathVariable(name = "creditID") final UUID creditID);

    @PostMapping("/customers")
    void saveCustomer(@RequestBody final Customer customer);

}
