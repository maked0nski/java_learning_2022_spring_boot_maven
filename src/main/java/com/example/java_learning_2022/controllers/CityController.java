package com.example.java_learning_2022.controllers;

import com.example.java_learning_2022.dao.CityDAO;
import com.example.java_learning_2022.models.entity.City;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
@AllArgsConstructor
public class CityController {
    private CityDAO cityDAO;

    @PostMapping("")
    public void saveCityWithUser(@RequestBody City city) {
        cityDAO.save(city);
    }

}