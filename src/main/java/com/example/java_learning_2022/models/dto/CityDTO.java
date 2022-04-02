package com.example.java_learning_2022.models.dto;

import com.example.java_learning_2022.models.entity.City;
import lombok.Data;

@Data
public class CityDTO {
    private String city;

    public CityDTO(City city) {
        this.city = city.getCityName();
    }
}
