package com.example.java_learning_2022.services.implementation;

import com.example.java_learning_2022.dao.CityDAO;
import com.example.java_learning_2022.models.dto.CityDTO;
import com.example.java_learning_2022.models.entity.City;
import com.example.java_learning_2022.services.ICityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CityService implements ICityService {
    private CityDAO cityDAO;

    @Override
    public List<CityDTO> findAllCity() {
        return cityDAO.findAll().stream().map(CityDTO::new).collect(Collectors.toList());
    }

    @Override
    public CityDTO findCityByID(int id) {
        return new CityDTO(cityDAO.getById(id));
    }

    @Override
    public void createCity(City city) {
        cityDAO.save(city);
    }

    @Override
    public CityDTO updateCity(int id, City city) {
        City cityBase = cityDAO.findById(id).orElse(null);
        if (cityBase != null){
            cityBase.setId(id);
        }
        assert cityBase != null;
        return new CityDTO(cityBase);
    }

    @Override
    public void deleteCity(int id) {
        cityDAO.deleteById(id);
    }
}
