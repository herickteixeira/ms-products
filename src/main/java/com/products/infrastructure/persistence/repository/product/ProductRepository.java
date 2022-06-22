package com.products.infrastructure.persistence.repository.product;

import com.products.core.domain.aggregates.product.Product;

import java.util.List;

public interface ProductRepository {

    void save(Product product);

    Product findById(String id);

    List<Product> findAll();

    void deleteById(String id);
}
