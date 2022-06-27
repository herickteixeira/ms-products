package com.products.infrastructure.persistence.repository.product;

import com.products.core.domain.aggregates.product.Product;
import com.products.core.domain.aggregates.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        var optionalProduct = jpaProductRepository.findById(id);

        if (optionalProduct.isEmpty())
            throw new RuntimeException(String.format("Product of id %s no found", id));

        var product = optionalProduct.get();

        return ProductMapper.map(product);
    }

    @Override
    public List<Product> findAll() {
        var products = jpaProductRepository.findAll();

        return ProductMapper.map(products);
    }

    @Override
    public void deleteById(String id) {
        jpaProductRepository.deleteById(id);
    }
}
