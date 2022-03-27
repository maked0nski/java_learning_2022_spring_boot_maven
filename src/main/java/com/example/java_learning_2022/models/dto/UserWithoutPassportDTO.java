package com.example.java_learning_2022.models.dto;

import com.example.java_learning_2022.models.entity.User;
import lombok.Data;

@Data
public class UserWithoutPassportDTO {
    private String name;
    private int age;

    public UserWithoutPassportDTO(User user) {
        this.name = user.getName();
        this.age = user.getAge();
    }
}
