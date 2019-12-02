package com.example.credit.service;

import com.example.credit.beans.Customer;
import com.example.credit.beans.Product;
import com.example.credit.entity.Credit;

import java.util.List;
import java.util.UUID;

public interface CreditService {

    List<Credit> getCredits();
    UUID saveCredit(final Credit credit);
    Product getProduct(final UUID creditID);
    void saveProduct(final Product product);
    Customer getCustomer(final UUID creditID);
    void saveCustomer(final Customer customer);
}
