package com.example.springdemo.springassignment.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
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



}
