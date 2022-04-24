package com.example.springdemo.springassignment.repository;

import com.example.springdemo.springassignment.entity.Order_Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<Order_Product,Integer> {
}
