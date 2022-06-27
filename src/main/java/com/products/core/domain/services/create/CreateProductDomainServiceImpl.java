package com.products.core.domain.services.create;

import com.products.core.domain.aggregates.category.Category;
import com.products.core.domain.aggregates.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateProductDomainServiceImpl implements CreateProductDomainService {

    @Override
    public Product execute(String id, String name, String description, Double price, List<Category> categories) {
        return Product.create(id, name, description, price, categories);
    }
}
