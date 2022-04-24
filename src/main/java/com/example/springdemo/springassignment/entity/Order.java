package com.example.springdemo.springassignment.entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;

@Entity
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public List<Order_Product> getOrder_products() {
        return order_products;
    }

    public void setOrder_products(List<Order_Product> order_products) {
        this.order_products = order_products;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
