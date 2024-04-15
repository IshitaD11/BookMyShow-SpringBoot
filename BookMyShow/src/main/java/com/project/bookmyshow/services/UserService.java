package com.project.bookmyshow.services;

import com.project.bookmyshow.models.User;
import com.project.bookmyshow.repositoris.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User signUp(String email, String password){
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if(optionalUser.isPresent())
            throw new RuntimeException("User already exists");

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setBookings(new ArrayList<>());

        return userRepository.save(user);
    }
}
