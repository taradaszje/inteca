package com.example.credit.beans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Product {

    private Long id;

    private UUID creditID;

    private String name;

    private Integer value;
}
