package com.example.java_learning_2022.controllers;


import com.example.java_learning_2022.dao.PostDAO;
import com.example.java_learning_2022.models.dto.PostDTO;
import com.example.java_learning_2022.models.entity.Post;
import com.example.java_learning_2022.services.IPostService;
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
    private IPostService postService;


    @GetMapping("")
    public ResponseEntity<List<PostDTO>> findAll() {
        return ResponseEntity.ok().body(postService.findAllPost());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(postService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PostDTO> update(@PathVariable("id") int id, @RequestBody Post post) {
        return ResponseEntity.ok().body(postService.updatePost(id, post));
    }

    @PostMapping("")
    public ResponseEntity<HttpStatus> createPost(@RequestBody Post post) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") int id) {
        postService.deletePost(id);
    }
}
