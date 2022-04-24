package com.example.springdemo.springassignment.repository;

import com.example.springdemo.springassignment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
