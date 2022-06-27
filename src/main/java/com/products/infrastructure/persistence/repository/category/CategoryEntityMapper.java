package com.products.infrastructure.persistence.repository.category;

import com.products.core.domain.aggregates.category.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryEntityMapper {

    public static CategoryEntity map(Category category) {
        var entity = new CategoryEntity();
        entity.setId(category.getId());
        entity.setName(category.getName());
        return entity;
    }

    public static List<CategoryEntity> map(List<Category> categories) {
        var category = new ArrayList<CategoryEntity>();
        for (var entity : categories)
            category.add(map(entity));
        return category;
    }
}
