package com.taradaszje.credit.beans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
public class Customer {
    private Long id;
    private String firstName;
    private String surname;
    private UUID creditID;
    private Long identityNumber;

    public static Customer createCustomer(final CreditForm creditForm,  final UUID creditID) {
        final Customer customer = new Customer();
        customer.setCreditID(creditID);
        customer.setFirstName(creditForm.getFirstName());
        customer.setIdentityNumber(creditForm.getIdentityNumber());
        customer.setSurname(creditForm.getLastName());
        return customer;
    }
}
