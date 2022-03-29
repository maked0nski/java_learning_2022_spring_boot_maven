package com.example.java_learning_2022.dao;

import com.example.java_learning_2022.models.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDAO extends JpaRepository<Address, Integer> {
}
