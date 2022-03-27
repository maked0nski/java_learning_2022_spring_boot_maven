package com.example.java_learning_2022.models.dto;

import com.example.java_learning_2022.models.entity.Passport;
import lombok.Data;

@Data
public class PassportDTO {
    private String series;

    public PassportDTO(Passport passport) {
        this.series = passport.getSeries();
    }
}
