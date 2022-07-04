package com.products.infrastructure.persistence.repository.product;

import com.products.application.shared.Page;
import com.products.application.shared.Pagination;
import com.products.core.domain.aggregates.product.Product;
import com.products.core.domain.aggregates.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;

    @Autowired
    public ProductRepositoryImpl(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public void save(Product product) {
        jpaProductRepository.save(ProductEntityMapper.map(product));
    }

    @Override
    public Product findById(String id) {
        var product = jpaProductRepository.findById(id).get();
        return ProductMapper.map(product);
    }

    @Override
    public Page<Product> findAll(Pagination pagination) {
        var products = jpaProductRepository.findProductsFetchCategories();

        return new Page<>(pagination.getOffset(), pagination.getLimit(), ProductMapper.map(products));
    }

    @Override
    public void deleteById(String id) {
        jpaProductRepository.deleteById(id);
    }
}
