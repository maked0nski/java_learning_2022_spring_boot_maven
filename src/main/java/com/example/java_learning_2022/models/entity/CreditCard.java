package com.example.java_learning_2022.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})

public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cardNumber;
    private String validity;
}
