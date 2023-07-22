package com.sachinkumar.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sachinkumar.demo.Models.User;
import com.sachinkumar.demo.Repository.AuthRepo;

@RestController
@RequestMapping("/auth")
@CrossOrigin(maxAge = 3600)
public class AuthController {

    @Autowired
    AuthRepo authRepo;

    @PostMapping("/register")
    public String register(@RequestBody User user) {

        List<User> allUsers = authRepo.findAll();

        for (User u : allUsers) {
            if (u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword())) {
                return "User Already Registered";
            }
        }

        authRepo.save(user);
        return "User Registered";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        List<User> allUsers = authRepo.findAll();

        for (User u : allUsers) {
            if (u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword())) {
                return "Login Successful";
            }
        }

        return "Login Failed";

    }

    @GetMapping("/users")
    public List<User> getUsers() {

        return authRepo.findAll();

    }

}
