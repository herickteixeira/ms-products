package com.products.infrastructure.persistence.repository.category;

import com.products.core.domain.aggregates.category.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {

    public static Category map(CategoryEntity entity) {
        return new Category(entity.getId(), entity.getName());
    }

    public static List<Category> map(List<CategoryEntity> entities) {
        var categories = new ArrayList<Category>();
        for (var entity : entities)
            categories.add(map(entity));
        return categories;
    }
}
