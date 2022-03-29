package com.example.java_learning_2022.controllers;


import com.example.java_learning_2022.dao.AddressDAO;
import com.example.java_learning_2022.models.dto.AddressDTO;
import com.example.java_learning_2022.models.entity.Address;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/address")
public class AddressController {
    private AddressDAO addressDAO;

    @GetMapping("")
    public ResponseEntity<List<AddressDTO>> findAll() {
        List<AddressDTO> addressDTOList = addressDAO.findAll().stream().map(AddressDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(addressDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> findById(@PathVariable("id") int id) {
        Address address = addressDAO.findById(id).orElse(new Address());
        if (address.getId() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(new AddressDTO(address), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AddressDTO> updateAdr(@PathVariable("id") int id, @RequestBody() Address address) {
        if (address == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        address.setId(id);
        addressDAO.save(address);
        return new ResponseEntity<>(new AddressDTO(address), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<AddressDTO> createAdr(@RequestBody Address address) {
        if (address == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        addressDAO.save(address);
        return new ResponseEntity<>(new AddressDTO(address), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<AddressDTO>> delAdr(@PathVariable("id") int id) {
        try {
            addressDAO.deleteById(id);
            return new ResponseEntity<>(addressDAO.findAll().stream().map(AddressDTO::new).collect(Collectors.toList()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}

