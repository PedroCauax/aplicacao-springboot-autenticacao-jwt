package com.springboot.Application.services;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.Application.models.User;
import com.springboot.Application.repositories.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public PasswordEncoder getPasswordEncoder() {
    return passwordEncoder;
    }
       
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
    public User registerUser(String username, String password) {
    if (userRepository.findByName(username).isPresent()) {
        throw new IllegalArgumentException("Username already exists");
    }
    String cryptPass = passwordEncoder.encode(password);
    User user = new User(username, cryptPass);
    return (User) userRepository.save(user);
    }
    public Optional<User> getForUsername(String username) {
    return userRepository.findByName(username);
    }
}
