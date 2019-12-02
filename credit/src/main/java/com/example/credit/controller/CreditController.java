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

import static com.example.credit.beans.CreditForm.createCreditForm;
import static com.example.credit.beans.Customer.createCustomer;
import static com.example.credit.beans.Product.createProduct;
import static com.example.credit.entity.Credit.createCredit;

@RestController
public class CreditController {

    @Autowired
    private CreditService creditService;

    @GetMapping(value = "/getCredits", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<CreditForm> getCredits() {
        final List<CreditForm> creditForms = new ArrayList<>();
        final List<Credit> credits = creditService.getCredits();
        credits.forEach(credit -> {
            final Product product = creditService.getProduct(credit.getCreditID());
            final Customer customer = creditService.getCustomer(credit.getCreditID());
            final CreditForm creditForm = createCreditForm(credit, product, customer);
            creditForms.add(creditForm);
        });
        return creditForms;
    }

    @PostMapping(value = "/createCredit", consumes = "application/json")
    public UUID saveCredit(@RequestBody final CreditForm creditForm) {
        final UUID creditID = UUID.randomUUID();
        creditService.saveCustomer(createCustomer(creditForm,creditID));
        creditService.saveProduct(createProduct(creditForm, creditID));
        return creditService.saveCredit(createCredit(creditForm, creditID));
    }
}
