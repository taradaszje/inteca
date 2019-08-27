package com.example.credit.beans;

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
    private UUID creditNumber;
    private Long identityNumber;
}
