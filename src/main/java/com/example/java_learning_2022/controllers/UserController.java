package com.example.java_learning_2022.controllers;

import com.example.java_learning_2022.dao.UserDAO;
import com.example.java_learning_2022.models.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserDAO userDAO;

    //    locallhost:8080/users         GET         - find all users
    @GetMapping("")
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<>(userDAO.findAll(), HttpStatus.OK);
    }

    //    locallhost:8080/users/ID      GET         - find user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") int id) {
////        return userDAO.findById(id).get();
////        return userDAO.findById(id).orElseThrow(() -> new RuntimeException());
//
//        return userDAO.findById(id).orElseThrow(RuntimeException::new);
        User user = userDAO.findById(id).orElse(new User());
        if (user.getId() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //    locallhost:8080/users/ID      PATCH/PUT   - update user
    @PatchMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user) {
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        user.setId(id);
        userDAO.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //    locallhost:8080/users         POST        - post user
    @PostMapping("")
    public ResponseEntity<List<User>> createUser(@RequestBody User user) {
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        userDAO.save(user);
        return new ResponseEntity<>(userDAO.findAll(), HttpStatus.OK);
    }

    //    locallhost:8080/users/ID      DELETE      - delete user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<List<User>> deleteUser(@PathVariable("id") int id) {
        try{
            userDAO.deleteById(id);
            return new ResponseEntity<>(userDAO.findAll(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findBy")
    public void findBy() {
        System.out.println(userDAO.findByAge(9));
        System.out.println(userDAO.findByName("Sasha"));
        System.out.println(userDAO.findByNameAndAge("Sasha", 25));
    }
}
