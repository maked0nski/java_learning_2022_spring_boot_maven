package com.example.java_learning_2022.controllers;

import com.example.java_learning_2022.dao.CreditCardDAO;
import com.example.java_learning_2022.models.dto.CreditCardDTO;
import com.example.java_learning_2022.models.entity.CreditCard;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/cards")
public class CreditCardController {
    private CreditCardDAO creditCardDAO;


    @GetMapping("")
    public ResponseEntity<List<CreditCardDTO>> getCard(){
        List<CreditCard> cards = creditCardDAO.findAll();
        return new ResponseEntity<>(cards.stream().map(CreditCardDTO::new).collect(Collectors.toList()), HttpStatus.OK);
    }



}
