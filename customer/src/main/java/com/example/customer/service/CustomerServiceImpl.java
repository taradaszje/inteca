package com.example.customer.service;

import com.example.customer.entity.Customer;
import com.example.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Resource
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomer(final UUID creditNumber) {
        return customerRepository.findByCreditID(creditNumber)
                .orElseThrow(()->new EntityNotFoundException(throwMessage(creditNumber)));
    }

    @Override
    public void saveCustomer(final Customer customer) {
        customerRepository.save(customer);
    }

    private String throwMessage(final UUID creditNumber) {
        return "Customer wit that credit number "+creditNumber+" not found.";
    }
}
