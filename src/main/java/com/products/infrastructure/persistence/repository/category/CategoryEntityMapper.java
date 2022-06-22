package com.products.infrastructure.persistence.repository.category;

import com.products.core.domain.aggregates.category.Category;

public class CategoryEntityMapper {

    public static CategoryEntity map(Category category) {
        var entity = new CategoryEntity();
        entity.setId(category.getId());
        entity.setName(category.getName());
        return entity;
    }
}
