package com.products.infrastructure.persistence.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<ProductEntity, String> {
}
