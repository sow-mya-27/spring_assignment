package com.example.springdemo.springassignment.repository;

import com.example.springdemo.springassignment.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products,Integer> {
}
