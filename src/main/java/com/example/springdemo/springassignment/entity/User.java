package com.example.springdemo.springassignment.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "enabled")
    private boolean aBoolean=true;

    @Column(name="username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "users" ,cascade = CascadeType.ALL)
    private List<Order> orders;

    public User(){}

    public User(  String userName,String email, String password, String role) {
        this.username = userName;
        this.password = password;
        this.email=email;
        this.role = role;
    }



}
