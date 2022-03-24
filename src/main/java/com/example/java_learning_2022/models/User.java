package com.example.java_learning_2022.models;

import lombok.*;

import javax.persistence.*;

@Entity
//@Table(name = "username")   // зміма назви (якщо в базі по інакшому називається)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "user_id")   // зміма назви колонки ІД
    private int id;
    private String name;
    private int age;
}
