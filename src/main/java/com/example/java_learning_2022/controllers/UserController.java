package com.example.java_learning_2022.controllers;

import com.example.java_learning_2022.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;


@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("")
    public void saveUser(@RequestParam String name, @RequestParam MultipartFile avatar, @RequestParam String email) throws IOException, MessagingException {
        userService.saveUser(name, avatar, email);
    }
}
