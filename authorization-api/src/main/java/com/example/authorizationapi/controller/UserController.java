package com.example.authorizationapi.controller;

import com.example.authorizationapi.model.User;
import com.example.authorizationapi.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @HystrixCommand(fallbackMethod = "DefaultLogList")
    public void registerUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @PostMapping("/login")
    @HystrixCommand(fallbackMethod = "DefaultLogList")
    public boolean login(@RequestParam String username, @RequestParam String password) {
        return userService.getPermissions(username, password);
    }

    @GetMapping("")
    @HystrixCommand(fallbackMethod = "DefaultLogList")
    public List<User> getAllUser() {
        return userService.getUserList();
    }

}
