package com.example.java_learning_2022.controllers;

import com.example.java_learning_2022.dao.UserDAO;
import com.example.java_learning_2022.models.dto.UserDTO;
import com.example.java_learning_2022.models.dto.UserWithoutPassportDTO;
import com.example.java_learning_2022.models.entity.User;
import com.example.java_learning_2022.services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
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

//    private UserDAO userDAO;
    private IUserService userService;

    @GetMapping("")
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok().body(userService.findAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable int id) {
        return ResponseEntity.ok(userService.findUserById(id));         // TODO зробити NOT_FOUND status.
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") int id, @RequestBody User user) {
        return ResponseEntity.ok().body(userService.updateUser(id, user));
    }

    @PostMapping("")
    public ResponseEntity<UserDTO> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

//    @PostMapping("/saveWithCard")
//    public void saveWithCard(@RequestBody User user){
//        userDAO.save(user);
//    }

    @PostMapping("/all")
    public List<UserDTO> saveUserBatch(@RequestBody List<User> users){
        userService.createUsers(users);
        return userService.findAllUser();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }

}
