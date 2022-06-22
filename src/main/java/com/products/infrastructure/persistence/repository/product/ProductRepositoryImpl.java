package com.products.infrastructure.persistence.repository.product;

import com.products.core.domain.aggregates.product.Product;

import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;

    public ProductRepositoryImpl(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public void save(Product product) {
        jpaProductRepository.save(ProductEntityMapper.map(product));

    }

    @Override
    public Product findById(String id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}
