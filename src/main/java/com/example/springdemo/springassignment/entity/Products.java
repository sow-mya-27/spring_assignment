package com.example.springdemo.springassignment.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
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



}
