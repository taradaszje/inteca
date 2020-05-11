package com.taradaszje.customer.service;

import com.taradaszje.customer.entity.Customer;

import java.util.UUID;

public interface CustomerService {
    Customer getCustomer(final UUID creditNumber);
    void saveCustomer(final Customer customer);
}
