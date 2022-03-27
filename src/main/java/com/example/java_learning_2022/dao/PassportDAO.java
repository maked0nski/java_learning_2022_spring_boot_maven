package com.example.java_learning_2022.dao;

import com.example.java_learning_2022.models.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportDAO extends JpaRepository<Passport, Integer> {
}
