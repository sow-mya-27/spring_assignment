package com.example.springdemo.springassignment.service_implementation;

import com.example.springdemo.springassignment.entity.User;
import com.example.springdemo.springassignment.repository.UserRepository;
import com.example.springdemo.springassignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int theId) {
        Optional<User> result = userRepository.findById(theId);

        User theUser = null;

        if (result.isPresent()) {
            theUser = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theUser;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(int Id) {
        userRepository.deleteById(Id);
    }

//    @Override
//    public List<User> findByName(String name) {
////        userRepository.
//        return null;
//    }
}
