package com.products.core.domain.aggregates.product;

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

        return response;
    }
}
