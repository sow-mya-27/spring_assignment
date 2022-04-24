package com.example.springdemo.springassignment.dto.orders;

import com.example.springdemo.springassignment.entity.Products;

public class ProductDto {
    private int id;
    private String name;
    private String price;

    public ProductDto(Products products){
        this.id = products.getId();
        this.name = products.getName();
        this.price = products.getPrice();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
