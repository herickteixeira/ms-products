package com.products.infrastructure.persistence.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaProductRepository extends JpaRepository<ProductEntity, String> {

    @Query(value = "SELECT p FROM ProductEntity p JOIN FETCH p.categories")
    List<ProductEntity> findProductsFetchCategories();
}
