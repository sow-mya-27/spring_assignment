package com.example.springdemo.springassignment.service_implementation;

import com.example.springdemo.springassignment.entity.Products;
import com.example.springdemo.springassignment.exceptions.NotFoundException;
import com.example.springdemo.springassignment.repository.ProductRepository;
import com.example.springdemo.springassignment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Products> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Products findById(int theId) {
        Optional<Products> result = productRepository.findById(theId);

        Products theProduct = null;

        if (result.isPresent()) {
            theProduct = result.get();
        }
        else {
            // we didn't find the employee
            throw new NotFoundException("Did not find employee id - " + theId);
        }

        return theProduct;
    }

    @Override
    public Products save(Products product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }
}
