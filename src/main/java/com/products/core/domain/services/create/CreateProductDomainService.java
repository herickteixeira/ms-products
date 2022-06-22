package com.products.core.domain.services.create;

import com.products.core.domain.aggregates.category.Category;
import com.products.core.domain.aggregates.product.Product;

public interface CreateProductDomainService {

    Product execute(
            String id,
            String name,
            String description,
            Double price,
            Category category);
}
