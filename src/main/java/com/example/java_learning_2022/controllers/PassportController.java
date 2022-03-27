package com.example.java_learning_2022.controllers;


import com.example.java_learning_2022.dao.PassportDAO;
import com.example.java_learning_2022.models.dto.PassportDTO;
import com.example.java_learning_2022.models.entity.Passport;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/passports")
@AllArgsConstructor
public class PassportController {

    private PassportDAO passportDAO;

    @GetMapping("")
    public List<PassportDTO> getPassports() {
        return passportDAO.findAll().stream().map(PassportDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassportDTO> passportById(@PathVariable("id") int id) {
        Passport passport = passportDAO.findById(id).orElse(new Passport());
        if (passport.getId() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(new PassportDTO(passport), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<List<PassportDTO>> createPassport(@RequestBody Passport passport){
        if (passport == null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        passportDAO.save(passport);
        return new ResponseEntity<>(passportDAO.findAll().stream().map(PassportDTO::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PassportDTO> updatePassport(@PathVariable("id") int id, @RequestBody Passport passport){
        passport.setId(id);
        passportDAO.save(passport);
        return new ResponseEntity<>(new PassportDTO(passport), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<PassportDTO>> deletePassport(@PathVariable("id") int id){
        try {
            passportDAO.deleteById(id);
            List<PassportDTO> passportDTOList = passportDAO.findAll().stream().map(PassportDTO::new).collect(Collectors.toList());
            return new ResponseEntity<>(passportDTOList, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
