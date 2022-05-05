package com.example.java_learning_2022.controllers;

import com.example.java_learning_2022.dao.services.UserService;
import com.example.java_learning_2022.models.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MainController {

    private UserService userService;

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @GetMapping("/securityURL")
    public String helloSecurity() {
        return "hello securityURL";
    }

    // lesson 8 security part 1   1:28:40  настройка постмен

    @PostMapping("/save")
    public void save(@RequestBody User user) {
        userService.save(user);
    }

}
