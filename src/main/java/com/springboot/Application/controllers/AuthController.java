package com.springboot.Application.controllers;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.springboot.Application.security.JwtUtil;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Application.models.User;
import com.springboot.Application.services.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
        User user = userService.registerUser(request.get("username"), request.get("password"));
        return ResponseEntity.ok(user);
        }

    @PostMapping("/login")
public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
    Optional<User> user = userService.getForUsername(request.get("username"));
    if (user.isPresent() && userService.getPasswordEncoder().matches(request.get("password"), user.get().getPassword())) {
        String token = JwtUtil.generateToken(user.get().getName());
        return ResponseEntity.ok(Map.of("token", token));
    }
    return ResponseEntity.status(401).body("Invalid credentials");
}
}
