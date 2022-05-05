package com.example.java_learning_2022.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.java_learning_2022.models.entity.AuthToken;

public interface AuthTokenDAO extends JpaRepository<AuthToken, Integer> {
    AuthToken findAuthTokenByToken(String token);
}
