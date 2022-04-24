package com.example.springdemo.springassignment.dto.orders;

import com.example.springdemo.springassignment.entity.Products;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductDto {
    private int id;
    private String name;
    private String price;

    public ProductDto(Products products){
        this.id = products.getId();
        this.name = products.getName();
        this.price = products.getPrice();
    }


}
