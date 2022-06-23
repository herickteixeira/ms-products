package com.products.core.domain.services.create;

import com.products.core.domain.aggregates.category.Category;
import com.products.core.domain.aggregates.product.Product;
import com.products.core.shared.validators.ObjectValidator;
import com.products.infrastructure.persistence.repository.product.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateProductDomainServiceImpl implements CreateProductDomainService {

    private final ProductRepository productRepository;

    public CreateProductDomainServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product execute(String id, String name, String description, Double price, Category category) {
        var product = productRepository.findById(id);

        if (ObjectValidator.isNull(product))
            product = Product.create(id, name, description, price, category);

        product.update(name, description, price, category);

        return product;
    }
}
