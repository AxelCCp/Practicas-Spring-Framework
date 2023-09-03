package com.app.rest.model.service;

import com.app.rest.model.entity.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();

    List<Product>findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);

    Optional<Product> findById(Long id);

    void save(Product product);

    void deleteById(Long id);

}
