package com.example.credit.service;

import com.example.credit.entity.Credit;

import java.util.List;
import java.util.UUID;

public interface CreditService {

    List<Credit> getCredits();
    UUID saveCredit(final Credit credit);
}
