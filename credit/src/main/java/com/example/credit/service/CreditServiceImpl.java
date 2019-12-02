package com.example.credit.service;

import com.example.credit.beans.Customer;
import com.example.credit.beans.Product;
import com.example.credit.entity.Credit;
import com.example.credit.proxies.CustomerServiceProxy;
import com.example.credit.proxies.ProductServiceProxy;
import com.example.credit.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CreditServiceImpl implements CreditService {

    @Resource
    private CreditRepository creditRepository;

    @Autowired
    private CustomerServiceProxy customerServiceProxy;

    @Autowired
    private ProductServiceProxy productServiceProxy;

    @Override
    public List<Credit> getCredits() {
        return StreamSupport.stream(creditRepository.findAll().spliterator(),false)
                        .collect(Collectors.toList());
    }

    @Override
    public UUID saveCredit(final Credit credit) {
        creditRepository.save(credit);
        return credit.getCreditID();
    }

    @Override
    public Product getProduct(final UUID creditID) {
        return productServiceProxy.getProduct(creditID);
    }

    @Override
    public void saveProduct(final Product product) {
        productServiceProxy.saveProduct(product);
    }

    @Override
    public Customer getCustomer(final UUID creditID) {
        return customerServiceProxy.getCustomer(creditID);
    }

    @Override
    public void saveCustomer(final Customer customer) {
        customerServiceProxy.saveCustomer(customer);
    }

}
