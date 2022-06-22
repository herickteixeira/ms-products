package com.products.core.domain.aggregates.product;

import com.products.core.domain.aggregates.category.Category;
import com.products.core.shared.validators.CustomValidator;

public class Product {
    private String id;
    private String name;
    private String description;
    private Double price;
    private Category category;

    public Product(String id, String name, String description, Double price, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public static Product create(String id, String name, String description, Double price, Category category) {
        var product = new Product(id, name, description, price, category);
        CustomValidator.validateAndThrow(product);
        return product;
    }

    public void update(String name, String description, Double price, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
