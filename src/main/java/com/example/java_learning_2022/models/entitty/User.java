package com.example.java_learning_2022.models.entitty;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.java_learning_2022.models.dto.UserDTO;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String avatar;
    private String email;

    public User(UserDTO userDTO) {
        this.name = userDTO.getName();
        this.avatar = userDTO.getAvatar();
        this.email = userDTO.getEmail();
    }

    public User(String name, String avatar) {
        this.name = name;
        this.avatar = avatar;
    }

    public User(String name, String avatar, String email) {
        this.name = name;
        this.avatar = avatar;
        this.email = email;
    }
}
