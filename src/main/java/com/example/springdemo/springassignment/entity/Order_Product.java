package com.example.springdemo.springassignment.entity;

import javax.persistence.*;


@Entity
@Table(name="order-product")
public class Order_Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_product_id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products products;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private int quantity;

    public Long getOrder_product_id() {
        return order_product_id;
    }

    public void setOrder_product_id(Long order_product_id) {
        this.order_product_id = order_product_id;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
