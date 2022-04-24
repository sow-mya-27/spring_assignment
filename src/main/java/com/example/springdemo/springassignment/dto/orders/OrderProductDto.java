package com.example.springdemo.springassignment.dto.orders;

import com.example.springdemo.springassignment.entity.Products;

public class OrderProductDto {
    private Integer quantity;
    private ProductDto productDto;

    public OrderProductDto(Integer quantity, Products products){
        this.quantity = quantity;
        this.productDto= new ProductDto(products);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }
}
