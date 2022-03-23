package com.example.java_learning_2022.dao;

import com.example.java_learning_2022.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {
}
