package com.example.springdemo.springassignment.entity;

import javax.persistence.*;
import java.util.List;

@Entity
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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }


}
