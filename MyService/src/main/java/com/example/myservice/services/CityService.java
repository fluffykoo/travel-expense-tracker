package com.example.myservice.services;

import com.example.myservice.entities.City;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {
    private List<City> cities = new ArrayList<>();

    public void addCity(City city) {
        cities.add(city);
    }

    public List<City> getCities() {
        return cities;
    }

    public List<City> getCitiesByDestinationId(int destinationId) {
        return cities.stream()
                .filter(c -> c.getDestinationId() == destinationId)
                .collect(Collectors.toList());
    }

    public City getCityById(int id) {
        return cities.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void deleteCity(int id) {
        cities.removeIf(c -> c.getId() == id);
    }
}
