package com.example.springdemo.springassignment.entity;

import javax.persistence.*;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "user-id")
    private User users;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Order_Product> order_products;

    private int totalPrice;

    public Order(){

    }

    public Order( User user, List<Order_Product> order_products, int totalPrice) {
        this.users = user;
        this.order_products = order_products;
        this.totalPrice = totalPrice;
    }


}
