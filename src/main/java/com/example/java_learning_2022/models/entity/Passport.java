package com.example.java_learning_2022.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})

public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String series;


    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport", cascade = CascadeType.ALL)
    @ToString.Exclude
    private User user;
}
