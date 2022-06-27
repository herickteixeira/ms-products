package com.products.core.domain.aggregates.product;

import java.util.List;

public interface ProductRepository {

    void save(Product product);

    Product findById(String id);

    List<Product> findAll();

    void deleteById(String id);
}
