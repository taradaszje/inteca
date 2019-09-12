package com.example.credit.controller;

import com.example.credit.beans.CreditForm;
import com.example.credit.beans.Customer;
import com.example.credit.beans.Product;
import com.example.credit.entity.Credit;
import com.example.credit.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class CreditController {

    private static String GET_PRODUCT_URL = "http://product-service/products?creditNumber={creditNumber}";
    private static String POST_PRODUCT_URL = "http://product-service/products";
    private static String GET_CUSTOMER_URL = "http://customer-service/customers?creditNumber={creditNumber}";
    private static String POST_CUSTOMER_URL = "http://customer-service/customers";

    @Autowired
    private CreditService creditService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/credits", produces = "application/json")
    @ResponseBody
    public List<CreditForm> getCredits() {
        final List<CreditForm> creditForms = new ArrayList<>();
        final List<Credit> credits = creditService.getCredits();
        credits.forEach(credit -> {
            final Product product = restTemplate.getForObject(GET_PRODUCT_URL,
                    Product.class, credit.getCreditNumber());

            final Customer customer = restTemplate.getForObject(GET_CUSTOMER_URL,
                    Customer.class, credit.getCreditNumber());

            final CreditForm creditForm = createCreditForm(credit, product, customer);
            creditForms.add(creditForm);
        });
        return creditForms;
    }

    @PostMapping(value = "/credits", consumes = "application/json")
    public UUID saveCredit(@RequestBody final CreditForm creditForm) {

        final Credit credit = createCredit(creditForm);

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        final HttpEntity<Product> productRequest = new HttpEntity<>(createProduct(creditForm, credit), headers);
        restTemplate.postForObject(POST_PRODUCT_URL, productRequest, Product.class);

        final HttpEntity<Customer> customerRequest = new HttpEntity<>(createCustomer(creditForm, credit), headers);
        restTemplate.postForObject(POST_CUSTOMER_URL, customerRequest, Customer.class);

        return creditService.saveCredit(credit);
    }

    private Customer createCustomer(final CreditForm creditForm, final Credit credit) {
        final Customer customer = new Customer();
        customer.setCreditNumber(credit.getCreditNumber());
        customer.setFirstName(creditForm.getFirstName());
        customer.setIdentityNumber(creditForm.getIdentityNumber());
        customer.setSurname(creditForm.getLastName());
        return customer;
    }

    private Product createProduct(final CreditForm creditForm, final Credit credit) {
        final Product product = new Product();
        product.setCreditNumber(credit.getCreditNumber());
        product.setName(creditForm.getProductName());
        product.setValue(creditForm.getProductValue());
        return product;
    }

    private Credit createCredit(final CreditForm creditForm) {
        final Credit credit = new Credit();
        credit.setCreditNumber(UUID.randomUUID());
        credit.setName(creditForm.getCreditName());
        return credit;
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
