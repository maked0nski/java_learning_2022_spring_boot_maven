package com.example.java_learning_2022.models.dto;

import com.example.java_learning_2022.models.entity.CreditCard;
import lombok.Data;

@Data
public class CreditCardDTO {
    private String cardNumber;
    private String validity;

    public CreditCardDTO(CreditCard creditCard) {
        this.cardNumber = creditCard.getCardNumber();
        this.validity = creditCard.getValidity();
    }
}
