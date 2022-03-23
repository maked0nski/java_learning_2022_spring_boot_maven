package com.example.java_learning_2022.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {
    @GetMapping("/")
    public String home(){
        return "Hello";
    }
}
