package com.example.java_learning_2022.models.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "username")   // зміма назви (якщо в базі по інакшому називається)
@NoArgsConstructor
@Getter
@Setter
@ToString

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Passport passport;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_city",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "city_id")
    )
    private List<City> cities;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn (name ="user_id")
    private List<CreditCard> creditCards = new ArrayList<>();


}
