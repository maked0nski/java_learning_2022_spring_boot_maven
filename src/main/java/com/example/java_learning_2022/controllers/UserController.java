package com.example.java_learning_2022.controllers;

import com.example.java_learning_2022.dao.UserDAO;
import com.example.java_learning_2022.models.dto.UserWithPassportDTO;
import com.example.java_learning_2022.models.dto.UserWithoutPassportDTO;
import com.example.java_learning_2022.models.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserDAO userDAO;

    @GetMapping("")
    public ResponseEntity<List<UserWithPassportDTO>> findAll() {
        List<User> allUsers = userDAO.findAll();
        List<UserWithPassportDTO> userWithPassportDTOS = allUsers.stream().map(UserWithPassportDTO::new).collect(Collectors.toList());
        ResponseEntity<List<UserWithPassportDTO>> response = new ResponseEntity<>(userWithPassportDTOS, HttpStatus.OK);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserWithPassportDTO> findById(@PathVariable int id) {
        User user = userDAO.findById(id).orElse(new User());
        if (user.getId() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(new UserWithPassportDTO(user), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserWithPassportDTO> updateUser(@PathVariable("id") int id, @RequestBody User user) {
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        user.setId(id);
        userDAO.save(user);
        return new ResponseEntity<>(new UserWithPassportDTO(user), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<List<UserWithoutPassportDTO>> createUser(@RequestBody User user) {
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        userDAO.save(user);
        return new ResponseEntity<>(userDAO.findAll().stream().map(UserWithoutPassportDTO::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping("/with-passport")
    public ResponseEntity<List<UserWithPassportDTO>> createUserWithPassport(@RequestBody User user) {
        userDAO.save(user);
        List<UserWithPassportDTO> list = userDAO.findAll().stream().map(UserWithPassportDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<UserWithPassportDTO>> deleteUser(@PathVariable("id") int id) {
        try {
            userDAO.deleteById(id);
            return new ResponseEntity<>(userDAO.findAll().stream().map(UserWithPassportDTO::new).collect(Collectors.toList()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
