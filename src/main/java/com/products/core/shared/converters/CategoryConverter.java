package com.products.core.shared.converters;

import com.products.core.domain.aggregates.category.Category;
import com.products.core.domain.aggregates.product.ProductRequest;
import com.products.core.shared.validators.ObjectValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryConverter {

    public static List<Category> execute(ProductRequest request) {

        var isValid = !ObjectValidator.isNull(request) && !ObjectValidator.isNull(request.getCategories());
        if (!isValid) return Collections.emptyList();

        var categories = new ArrayList<Category>();
        for (var categoryRequest : request.getCategories()) {
            categories.add(Category.create(
                    categoryRequest.getId(),
                    categoryRequest.getName()));
        }

        return categories;
    }
}
