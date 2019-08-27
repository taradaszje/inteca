package com.example.credit.service;

import com.example.credit.entity.Credit;
import com.example.credit.repository.CreditRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CreditServiceImpl implements CreditService {

    @Resource
    private CreditRepository creditRepository;

    @Override
    public List<Credit> getCredits() {
        return StreamSupport.stream(creditRepository.findAll().spliterator(),false)
                        .collect(Collectors.toList());
    }

    @Override
    public UUID saveCredit(final Credit credit) {
        creditRepository.save(credit);
        return credit.getCreditNumber();
    }

}
