package com.booking.online_booking.service;

import com.booking.online_booking.model.User;
import com.booking.online_booking.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    
    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User findById(User u) {
        return userRepository.findById(u.getCin()).orElse(null);
    }
}
