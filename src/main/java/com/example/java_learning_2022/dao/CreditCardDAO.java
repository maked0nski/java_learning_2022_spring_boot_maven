package com.example.java_learning_2022.dao;

import com.example.java_learning_2022.models.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardDAO extends JpaRepository<CreditCard, Integer> {
}
