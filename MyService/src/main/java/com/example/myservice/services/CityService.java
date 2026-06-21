package com.example.myservice.services;

import com.example.myservice.entities.City;
import com.example.myservice.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public void addCity(City city) {
        cityRepository.save(city);
    }

    public List<City> getCities() {
        return cityRepository.findAll();
    }

    public List<City> getCitiesByDestinationId(int destinationId) {
        return cityRepository.findAll().stream()
                .filter(c -> c.getDestinationId() == destinationId)
                .collect(Collectors.toList());
    }

    public City getCityById(int id) {
        return cityRepository.findById(id).orElse(null);
    }

    public void deleteCity(int id) {
        cityRepository.deleteById(id);
    }
}
