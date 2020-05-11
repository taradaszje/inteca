package com.taradaszje.credit.controller;

import com.taradaszje.credit.beans.CreditForm;
import com.taradaszje.credit.beans.Customer;
import com.taradaszje.credit.beans.Product;
import com.taradaszje.credit.entity.Credit;
import com.taradaszje.credit.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.taradaszje.credit.beans.CreditForm.createCreditForm;
import static com.taradaszje.credit.beans.Customer.createCustomer;
import static com.taradaszje.credit.beans.Product.createProduct;
import static com.taradaszje.credit.entity.Credit.createCredit;

@RestController
public class CreditController {

    private final CreditService creditService;

    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @GetMapping(value = "/credits", produces = MediaType.APPLICATION_JSON_VALUE)
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

    @PostMapping(value = "/credits", consumes = "application/json")
    public UUID saveCredit(@RequestBody final CreditForm creditForm) {
        final UUID creditID = UUID.randomUUID();
        creditService.saveCustomer(createCustomer(creditForm,creditID));
        creditService.saveProduct(createProduct(creditForm, creditID));
        return creditService.saveCredit(createCredit(creditForm, creditID));
    }
}
