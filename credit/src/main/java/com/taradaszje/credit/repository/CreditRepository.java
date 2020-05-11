package com.taradaszje.credit.repository;

import com.taradaszje.credit.entity.Credit;
import org.springframework.data.repository.CrudRepository;


public interface CreditRepository extends CrudRepository<Credit, Long> {
}
