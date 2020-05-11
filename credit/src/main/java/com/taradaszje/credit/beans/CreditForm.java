package com.taradaszje.credit.beans;


import com.taradaszje.credit.entity.Credit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreditForm {
    private String creditName;
    private String firstName;
    private String lastName;
    private Long identityNumber;
    private String productName;
    private Integer productValue;

    public static CreditForm createCreditForm(final Credit credit, final Product product, final Customer customer) {
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
