package com.taradaszje.product.services;

import com.taradaszje.product.entity.Product;

import java.util.UUID;

public interface ProductService {
    Product getProduct(final UUID creditNumber);
    void saveProduct(final Product product);
}
