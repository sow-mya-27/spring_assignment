package com.example.springdemo.springassignment.service;

import com.example.springdemo.springassignment.entity.User;


import java.util.List;

public interface UserService {
    public List<User> findAll();

    public User findById(int theId);

    public User save(User user);

    public void deleteById(int Id);

}
