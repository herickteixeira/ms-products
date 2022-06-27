package com.products.core.domain.services.create;

import com.products.core.domain.aggregates.category.Category;
import com.products.core.domain.aggregates.product.Product;

import java.util.List;

public interface CreateProductDomainService {

    Product execute(
            String id,
            String name,
            String description,
            Double price,
            List<Category> categories);
}
