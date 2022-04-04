package com.example.java_learning_2022.models.dto;

import com.example.java_learning_2022.models.entity.Post;
import lombok.Data;

@Data
public class PostDTO {
    private String title;
    private String body;
    private int userId;

    public PostDTO(Post post) {
        this.title = post.getTitle();
        this.body = post.getBody();
        this.userId = post.getUserId();
    }
}
