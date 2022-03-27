package com.example.java_learning_2022.models.dto;

import com.example.java_learning_2022.models.entity.User;
import lombok.Data;

@Data
public class UserWithPassportDTO {
    private String name;
    private int age;
    private PassportDTO passportDTO;

    public UserWithPassportDTO(User user) {
        this.name = user.getName();
        this.age = user.getAge();
        this.passportDTO = new PassportDTO(user.getPassport());
    }
}
