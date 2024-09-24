package com.scaler.bookmyshow.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scaler.bookmyshow.models.User;
import com.scaler.bookmyshow.repositories.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signUp(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (!userOptional.isEmpty()) {
            throw new RuntimeException("user already exists");
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setBookings(new ArrayList<>());
        User savedUser = userRepository.save(user);
        return savedUser;
    }
}