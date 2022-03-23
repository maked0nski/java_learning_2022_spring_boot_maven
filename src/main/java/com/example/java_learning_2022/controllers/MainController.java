package com.example.java_learning_2022.controllers;

import com.example.java_learning_2022.models.*;
//import com.example.java_learning_2022.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    List<User> users = new ArrayList<>();
    List<Post> posts = new ArrayList<>();


    public MainController(){
        users.add(new User(2,"kokos", true));
        users.add(new User(1,"ananas", true));
        users.add(new User(3,"banana", false));
        users.add(new User(4,"tomat", true));
        users.add(new User(5,"mango", false));
        users.add(new User(6,"lime", false));

        posts.add(new Post(1,"title1", "body1", 1));
        posts.add(new Post(2,"title2", "body2", 2));
        posts.add(new Post(3,"title3", "body3", 3));
        posts.add(new Post(4,"title4", "body4", 4));
        posts.add(new Post(5,"title5", "body5", 5));
        posts.add(new Post(6,"title6", "body6", 6));

    }



    @GetMapping("/")
    public String welcome(){
        return "Welcome";
    }

    @GetMapping("/users")
    public List<User> users(){
        return users;
    }

    @GetMapping("/users/{id}")
    public User user(@PathVariable("id") int id){
        return users.stream().filter(user -> user.getId()==id).findFirst().get();
    }

    @GetMapping("/user")
    public User getUserByParams(@RequestParam("userId") int userId ) {
        return users.stream().filter(user -> user.getId()==userId).findFirst().get();
    }

    @PostMapping("/user")
    public List<User> saveUser(@RequestBody User user) {
        System.out.println(user);
        if (user!= null){
            users.add(user);
        }else {
            throw new RuntimeException("no user");
        }
        return users;
    }

    @PutMapping("/users/{id}")
    public List<User> putUser(@PathVariable int id, @RequestBody User user){
        User findUser = users.stream().filter(user1 -> user1.getId() == id).findFirst().get();
        int indexOf = users.indexOf(findUser);
        users.set(indexOf, user);
        return users;
    }

    @DeleteMapping("/users/{id}")
    public List<User> deleteUser(@PathVariable int id){
        users.removeIf(next -> next.getId() == id);
        return users;
    }

    @GetMapping("/posts")
    public List<Post> posts(){
        return posts;
    }

    @GetMapping("/posts/{id}")
    public Post post(@PathVariable("id") int id){
        return posts.stream().filter(post -> post.getId()==id).findFirst().get();
    }

    @GetMapping("/posts")
    public Post getPOstById(@RequestParam("postID") int postID){
        return posts.stream().filter(post -> post.getId()==postID).findFirst().get();
    }

    @PostMapping("/posts")
    public List<Post> savePost(@RequestBody Post post){
        if (post!= null){
            posts.add(post);
        }else {
            throw new RuntimeException("Request Body is empty");
        }
        return posts;
    }

}
