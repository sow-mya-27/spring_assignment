package com.example.springdemo.springassignment.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Products {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private String price;

    public Products(){

    }

    public Products(int id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Products(String name, String price) {
        this.name = name;
        this.price = price;
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
