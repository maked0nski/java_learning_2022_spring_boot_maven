package com.example.java_learning_2022.controllers;


import com.example.java_learning_2022.dao.PostDAO;
import com.example.java_learning_2022.models.Post;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {
    private PostDAO postDAO;

    @GetMapping("")
    public ResponseEntity<List<Post>> findAll() {
        return new ResponseEntity<>(postDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable("id") int id) {
        Post post = postDAO.findById(id).orElse(new Post());
        if (post.getId() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Post> update(@PathVariable("id") int id, @RequestBody Post post) {
        if (post.getId() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    //    locallhost:8080/users         POST        - post user
    @PostMapping("")
    public ResponseEntity<List<Post>> createPost(@RequestBody Post post) {
        if (post == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        postDAO.save(post);
        return new ResponseEntity<>(postDAO.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Post>> deletePost(@PathVariable("id") int id) {
        try {
            postDAO.deleteById(id);
            return new ResponseEntity<>(postDAO.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
