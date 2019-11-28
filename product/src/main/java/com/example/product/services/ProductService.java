package com.example.product.services;

import com.example.product.entity.Product;

import java.util.UUID;

public interface ProductService {
    Product getProduct(final UUID creditNumber);
    void saveProduct(final Product product);
}
