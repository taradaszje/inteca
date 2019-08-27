package com.example.credit.beans;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class CreditForm {
    private String firstName;
    private String lastName;
    private Long identityNumber;
    private String productName;
    private Integer productValue;
    private String creditName;
}
