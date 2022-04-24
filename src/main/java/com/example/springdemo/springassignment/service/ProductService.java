package com.example.springdemo.springassignment.service;

import com.example.springdemo.springassignment.entity.Products;

import java.util.List;

public interface ProductService {

    public List<Products> findAll();

    public Products findById(int theId);

    public Products save(Products user);

    public void deleteById(int Id);
}
