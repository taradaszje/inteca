package com.example.product.repository;

import com.example.product.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    Optional<Product> findByCreditID(final UUID creditId);
}
