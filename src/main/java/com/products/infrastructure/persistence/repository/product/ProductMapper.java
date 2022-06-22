package com.products.infrastructure.persistence.repository.product;

import com.products.core.domain.aggregates.product.Product;
import com.products.infrastructure.persistence.repository.category.CategoryMapper;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {

    public static Product map(ProductEntity entity) {
        return new Product(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice(),
                CategoryMapper.map(entity.getCategory()));
    }

    public static List<Product> map(List<ProductEntity> entities) {
        var products = new ArrayList<Product>();
        for (var entity : entities)
            products.add(map(entity));
        return products;
    }
}
