package com.naumdeveloper.web.dto;

import com.naumdeveloper.web.entities.Product;

public class ProductDto {
    private Long id;
    private String name;
    private Double price;

    public ProductDto() {
    }

    public ProductDto(Product product) {
        this.id  = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
    }

    public ProductDto(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
