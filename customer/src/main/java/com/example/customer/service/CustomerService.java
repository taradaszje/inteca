package com.example.customer.service;

import com.example.customer.entity.Customer;

import java.util.UUID;

public interface CustomerService {
    Customer getCustomer(final UUID creditNumber);
    void saveCustomer(final Customer customer);
}
