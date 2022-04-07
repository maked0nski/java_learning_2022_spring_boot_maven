package com.example.java_learning_2022.services.implementation;

import com.example.java_learning_2022.dao.PostDAO;
import com.example.java_learning_2022.models.dto.PostDTO;
import com.example.java_learning_2022.models.entity.Post;
import com.example.java_learning_2022.services.IPostService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Data
public class PostService implements IPostService {

    private PostDAO postDAO;


    @Override
    public List<PostDTO> findAllPost() {
        return postDAO.findAll().stream().map(PostDTO::new).collect(Collectors.toList());
    }

    @Override
    public PostDTO findById(int id) {
        Post post = postDAO.findById(id).orElse(new Post());
        if (post.getId() == 0) {
            return null;
        }
        return new PostDTO(post);
    }

    @Override
    public PostDTO updatePost(int id, Post post) {
        Post postBase = postDAO.findById(id).orElse(null);
        if (postBase != null) {
            if (post.getTitle() != "") {
                postBase.setTitle(post.getTitle());
            }
            if (post.getBody() != "") {
                postBase.setBody(post.getBody());
            }
            if (post.getUserId() != 0) {
                postBase.setUserId(post.getUserId());
            }
            return new PostDTO(postDAO.save(postBase));
        } else {
            post.setId(id);
            return new PostDTO(postDAO.save(post));
        }
    }

    @Override
    public void createPost(Post post) {
        if (post == null) {
            postDAO.save(post);
        }
    }

    @Override
    public void deletePost(int id) {
        postDAO.deleteById(id);
    }
}
