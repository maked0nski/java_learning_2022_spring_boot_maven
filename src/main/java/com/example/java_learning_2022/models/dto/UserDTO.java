package com.example.java_learning_2022.models.dto;

import com.example.java_learning_2022.models.entity.User;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserDTO {
    private String name;
    private int age;
    private PassportDTO passport;
    private List<CityDTO> cities;
    private List<CreditCardDTO> creditCards;


    public UserDTO(User user) {
        this.name = user.getName();
        this.age = user.getAge();

        try {
            this.passport = new PassportDTO(user.getPassport());
        } catch (Exception e) {
            this.passport = null;
        }
        try {
            this.cities = user.getCities().stream().map(CityDTO::new).collect(Collectors.toList());
        } catch (Exception e) {
            this.cities = null;
        }
        try {
            this.creditCards = user.getCreditCards().stream().map(CreditCardDTO::new).collect(Collectors.toList());
        } catch (Exception e) {
            this.creditCards = null;
        }

    }


}
