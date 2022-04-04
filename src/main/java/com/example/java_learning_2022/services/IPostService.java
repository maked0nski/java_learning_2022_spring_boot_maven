package com.example.java_learning_2022.services;

import com.example.java_learning_2022.models.dto.PostDTO;
import com.example.java_learning_2022.models.entity.Post;

import java.util.List;

public interface IPostService {

    List<PostDTO> findAllPost();

    PostDTO findById(int id);

    PostDTO updatePost(int id, Post post);

    void createPost(Post post);

    void deletePost(int id);
}
