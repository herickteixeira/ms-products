package com.products.core.domain.aggregates.product;

import com.products.application.shared.Page;
import com.products.application.shared.Pagination;

import java.util.List;

public interface ProductRepository {

    void save(Product product);

    Product findById(String id);

    Page<Product> findAll(Pagination pagination);

    void deleteById(String id);
}
