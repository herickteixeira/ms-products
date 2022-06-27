package com.products.core.domain.aggregates.product;

import com.products.core.domain.aggregates.category.CategoryRequest;

import java.util.List;

public class ProductRequest {

    private String id;
    private String name;
    private String description;
    private Double price;
    private List<CategoryRequest> categories;

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

    public List<CategoryRequest> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryRequest> categories) {
        this.categories = categories;
    }
}
