package com.example.java_learning_2022.controllers;

import com.example.java_learning_2022.dao.UserDAO;
import com.example.java_learning_2022.models.dto.UserDTO;
import com.example.java_learning_2022.models.dto.UserWithoutPassportDTO;
import com.example.java_learning_2022.models.entity.User;
import com.example.java_learning_2022.services.IUserService;
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
    private IUserService userService;

//    @GetMapping("")
//    public ResponseEntity<List<UserDTO>> findAll() {
//        List<User> allUsers = userDAO.findAll();
//        List<UserDTO> userWithPassportDTOS = allUsers.stream().map(UserDTO::new).collect(Collectors.toList());
//        ResponseEntity<List<UserDTO>> response = new ResponseEntity<>(userWithPassportDTOS, HttpStatus.OK);
//        return response;
//    }

    @GetMapping("")
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok().body(userService.findAllUser());     // TODO зробити NOT_FOUND status.
//        return new ResponseEntity<>(userService.findAllUser(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable int id) {
        return ResponseEntity.ok(userService.findUserById(id));         // TODO зробити NOT_FOUND status.
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") int id, @RequestBody User user) {
//        if (user == null) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        user.setId(id);
//        userDAO.save(user);
//        return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
        return null;
    }

    @PostMapping("")
    public ResponseEntity<UserDTO> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PostMapping("/with-passport")
    public ResponseEntity<UserDTO> createUserWithPassport(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteUser(@PathVariable("id") int id) {
        int deleteUserId = userService.deleteUser(id);
        HttpStatus status = HttpStatus.OK;
        if (deleteUserId == 0){
            status= HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(deleteUserId, status);
    }

    @PostMapping("/saveWithCard")
    public void saveWithCard(@RequestBody User user){
        userDAO.save(user);
    }


    @PostMapping("/all")
    public List<UserDTO> saveUserBatch(@RequestBody List<User> users){
        userService.createUsers(users);
        return userService.findAllUser();
    }

//    @PostMapping("/all")
//    public ResponseEntity<UserDTO> saveUserBatch(@RequestBody List<User> users){
//        userService.createUsers(users);
//        return userService.findAllUser();
//    }

}
