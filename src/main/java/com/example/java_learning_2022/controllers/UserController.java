package com.example.java_learning_2022.controllers;

import com.example.java_learning_2022.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    //    locallhost:8080/users         GET         - find all users

    @GetMapping("")
    public List<User> findAll() {
        return null;
    }


    //    locallhost:8080/users/ID      GET         - find user by ID

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") int id) {
        return null;
    }


    //    locallhost:8080/users/ID      PATCH/PUT   - update user
    @PatchMapping("/{id}")
    public User updateUser(@PathVariable("id") int id, @RequestBody User user) {

        return null;
    }


    //    locallhost:8080/users         POST        - post user
    @PostMapping("")
    public List<User> createUser(@RequestBody User user) {

        return null;
    }

    //    locallhost:8080/users/ID      DELETE      - delete user by ID
    @DeleteMapping("/{id}")
    public List<User> deleteUser(@PathVariable("id") int id) {

        return null;
    }


}
