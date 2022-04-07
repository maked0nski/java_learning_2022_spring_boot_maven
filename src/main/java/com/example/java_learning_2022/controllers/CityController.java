package com.example.java_learning_2022.controllers;

import com.example.java_learning_2022.dao.CityDAO;
import com.example.java_learning_2022.models.dto.CityDTO;
import com.example.java_learning_2022.models.entity.City;
import com.example.java_learning_2022.services.ICityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
@AllArgsConstructor
public class CityController {
    private ICityService cityService;

    @GetMapping("")
    public ResponseEntity<List<CityDTO>> findAll(){
        return ResponseEntity.ok().body(cityService.findAllCity());
    }

    @GetMapping("/id")
    public ResponseEntity<CityDTO> findById(int id){
        return ResponseEntity.ok().body(cityService.findCityByID(id));
    }

    @PostMapping("")
    public void saveCityWithUser(@RequestBody City city){
        cityService.createCity(city);
    }

    @PatchMapping("/id")
    public ResponseEntity<CityDTO> updateCity(int id, City city){
        return ResponseEntity.ok().body(cityService.updateCity(id,city));
    }

    @DeleteMapping("/id")
    public void deleteCity(int id){
        cityService.deleteCity(id);
    }

}