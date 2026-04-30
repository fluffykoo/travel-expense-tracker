package com.example.myservice.controllers;

import com.example.myservice.entities.City;
import com.example.myservice.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CityController {

    @Autowired
    CityService cityService;

    @PostMapping("/cities")
    public void addCity(@RequestBody City city) {
        cityService.addCity(city);
    }

    @GetMapping("/cities")
    public List<City> getCities() {
        return cityService.getCities();
    }

    @GetMapping("/cities/{id}")
    public City getCityById(@PathVariable int id) {
        return cityService.getCityById(id);
    }

    @GetMapping("/cities/destination/{destinationId}")
    public List<City> getCitiesByDestination(@PathVariable int destinationId) {
        return cityService.getCitiesByDestinationId(destinationId);
    }

    @DeleteMapping("/cities/{id}")
    public void deleteCity(@PathVariable int id) {
        cityService.deleteCity(id);
    }
}
