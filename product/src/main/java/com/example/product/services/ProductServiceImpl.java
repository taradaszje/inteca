package com.example.product.services;

import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{

    @Resource
    private ProductRepository productRepository;

    @Override
    public Product getProducts(final UUID creditNumber) {
        return productRepository.findByCreditNumber(creditNumber)
                .orElseThrow(() -> new EntityNotFoundException(throwMessage(creditNumber)));
    }

    @Override
    public void saveProduct(final Product product){
        productRepository.save(product);
    }

    private String throwMessage(final UUID creditNumber) {
        return "Product with that credit number "+ creditNumber+ " not found.";
    }
}
