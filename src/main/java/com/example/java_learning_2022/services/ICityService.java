package com.example.java_learning_2022.services;

import com.example.java_learning_2022.models.dto.CityDTO;
import com.example.java_learning_2022.models.entity.City;

import java.util.List;

public interface ICityService {
    List<CityDTO> findAllCity();

    CityDTO findCityByID(int id);

    void createCity(City city);

    CityDTO updateCity(int id, City city);

    void deleteCity(int id);

}
