package com.example.credit.controller;

import com.example.credit.beans.CreditForm;
import com.example.credit.beans.Customer;
import com.example.credit.beans.Product;
import com.example.credit.entity.Credit;
import com.example.credit.proxies.CustomerServiceProxy;
import com.example.credit.proxies.ProductServiceProxy;
import com.example.credit.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class CreditController {

    @Autowired
    private ProductServiceProxy productServiceProxy;

    @Autowired
    private CustomerServiceProxy customerServiceProxy;

    @Autowired
    private CreditService creditService;


    @GetMapping(value = "/getCredits", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<CreditForm> getCredits() {
        final List<CreditForm> creditForms = new ArrayList<>();
        final List<Credit> credits = creditService.getCredits();
        credits.forEach(credit -> {
            final Product product = productServiceProxy.getProduct(credit.getCreditID());
            final Customer customer = customerServiceProxy.getCustomer(credit.getCreditID());
            final CreditForm creditForm = createCreditForm(credit, product, customer);
            creditForms.add(creditForm);
        });
        return creditForms;
    }

    @PostMapping(value = "/createCredit", consumes = "application/json")
    public UUID saveCredit(@RequestBody final CreditForm creditForm) {
        final UUID creditID = UUID.randomUUID();
        productServiceProxy.saveProduct(createProduct(creditForm, creditID));
        customerServiceProxy.saveCustomer(createCustomer(creditForm,creditID));
        return creditService.saveCredit(createCredit(creditForm, creditID));
    }

    private Credit createCredit(@RequestBody CreditForm creditForm, UUID creditID) {
        final Credit credit = new Credit();
        credit.setName(creditForm.getCreditName());
        credit.setCreditID(creditID);
        return credit;
    }

    private Customer createCustomer(final CreditForm creditForm,  final UUID creditID) {
        final Customer customer = new Customer();
        customer.setCreditID(creditID);
        customer.setFirstName(creditForm.getFirstName());
        customer.setIdentityNumber(creditForm.getIdentityNumber());
        customer.setSurname(creditForm.getLastName());
        return customer;
    }

    private Product createProduct(final CreditForm creditForm, final UUID creditID) {
        final Product product = new Product();
        product.setCreditID(creditID);
        product.setName(creditForm.getProductName());
        product.setValue(creditForm.getProductValue());
        return product;
    }

    private CreditForm createCreditForm(final Credit credit, final Product product, final Customer customer) {
        final CreditForm creditForm = new CreditForm();
        creditForm.setFirstName(customer.getFirstName());
        creditForm.setIdentityNumber(customer.getIdentityNumber());
        creditForm.setLastName(customer.getSurname());
        creditForm.setCreditName(credit.getName());
        creditForm.setProductName(product.getName());
        creditForm.setProductValue(product.getValue());
        return creditForm;
    }
}
