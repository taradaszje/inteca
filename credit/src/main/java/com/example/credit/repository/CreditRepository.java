package com.example.credit.repository;

import com.example.credit.entity.Credit;
import org.springframework.data.repository.CrudRepository;


public interface CreditRepository extends CrudRepository<Credit, Long> {
}
