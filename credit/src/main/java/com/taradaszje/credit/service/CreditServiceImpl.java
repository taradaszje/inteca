package com.taradaszje.credit.service;

import com.taradaszje.credit.beans.Customer;
import com.taradaszje.credit.beans.Product;
import com.taradaszje.credit.entity.Credit;
import com.taradaszje.credit.proxies.CustomerServiceProxy;
import com.taradaszje.credit.proxies.ProductServiceProxy;
import com.taradaszje.credit.repository.CreditRepository;
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

    private final CustomerServiceProxy customerServiceProxy;

    private final ProductServiceProxy productServiceProxy;

    public CreditServiceImpl(CustomerServiceProxy customerServiceProxy, ProductServiceProxy productServiceProxy) {
        this.customerServiceProxy = customerServiceProxy;
        this.productServiceProxy = productServiceProxy;
    }

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
