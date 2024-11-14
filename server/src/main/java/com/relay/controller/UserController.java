package com.relay.controller;

import com.relay.model.User;
import com.relay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org. springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user){
        return userService.loginUser(user);
    }
}