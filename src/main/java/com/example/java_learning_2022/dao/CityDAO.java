package com.example.java_learning_2022.dao;

import com.example.java_learning_2022.models.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDAO extends JpaRepository<City, Integer> {
}
