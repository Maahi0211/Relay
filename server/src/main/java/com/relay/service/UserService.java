package com.relay.service;

import com.relay.model.User;
import com.relay.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    private BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    public ResponseEntity<String> registerUser(User user){
        if (userRepo.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email is already in use.");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return ResponseEntity.ok("User is registered successfully.");
    }
    public ResponseEntity<String> loginUser(User user){
        User existingUser=userRepo.findByEmail(user.getEmail())
                .orElse(null);
        if(existingUser==null || !passwordEncoder.matches(user.getPassword(), existingUser.getPassword())){
            return ResponseEntity.status(401).body("Invalid email or password.");
        }

        return ResponseEntity.ok("Login successful.");
    }
}