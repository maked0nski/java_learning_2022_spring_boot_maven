package com.example.java_learning_2022.dao;

import com.example.java_learning_2022.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Integer> {

    List<User> findByAge(int age);
    List<User> findByName(String name);
    List<User> findByNameAndAge(String name, int age);
}
