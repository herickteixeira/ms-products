package com.products.core.domain.aggregates.product;

import com.products.core.domain.aggregates.category.CategoryResponse;

import java.util.ArrayList;
import java.util.List;

public class ProductResponseMapper {

    public static List<ProductResponse> map(List<Product> products) {
        var responses = new ArrayList<ProductResponse>();
        for (var product : products)
            responses.add(map(product));
        return responses;
    }

    public static ProductResponse map(Product product) {
        var response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setCategories(categoryMap(product));

        return response;
    }

    private static List<CategoryResponse> categoryMap(Product product) {
        var responses = new ArrayList<CategoryResponse>();
        for (var category : product.getCategories()) {
            var categoryResponse = new CategoryResponse();
            categoryResponse.setId(category.getId());
            categoryResponse.setName(category.getName());
            responses.add(categoryResponse);
        }
        return responses;
    }
}
