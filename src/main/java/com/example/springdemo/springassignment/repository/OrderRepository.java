package com.example.springdemo.springassignment.repository;

import com.example.springdemo.springassignment.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
