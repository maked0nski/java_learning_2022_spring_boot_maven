package com.example.java_learning_2022.models.dto;

import com.example.java_learning_2022.models.entity.Address;
import lombok.Data;

@Data
public class AddressDTO {
    private String city;
    private String street;

    public AddressDTO(Address address) {
        this.city = address.getCity();
        this.street = address.getStreet();
    }
}
