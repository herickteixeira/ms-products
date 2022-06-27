package com.products.core.domain.aggregates.product;

import com.products.core.domain.aggregates.category.Category;

import java.util.List;

public class Product {
    private String id;
    private String name;
    private String description;
    private Double price;
    private List<Category> categories;

    public Product(String id, String name, String description, Double price, List<Category> categories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categories = categories;
    }

    public static Product create(String id, String name, String description, Double price, List<Category> categories) {
        var product = new Product(id, name, description, price, categories);
        return product;
    }

    public void update(String name, String description, Double price, List<Category> categories) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.categories = categories;
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
