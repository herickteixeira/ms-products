package com.products.infrastructure.persistence.repository.product;

import com.products.core.domain.aggregates.product.Product;
import com.products.infrastructure.persistence.repository.category.CategoryEntityMapper;

public class ProductEntityMapper {

    private ProductEntityMapper() {
    }

    public static ProductEntity map(Product product) {
        var entity = new ProductEntity();
        entity.setId(product.getId());
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setPrice(product.getPrice());
        entity.setCategory(CategoryEntityMapper.map(product.getCategory()));
        return entity;
    }
}
