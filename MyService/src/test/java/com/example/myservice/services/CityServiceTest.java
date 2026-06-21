package com.example.myservice.services;

import com.example.myservice.entities.City;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CityServiceTest {

    @Autowired
    private CityService service;

    @Test
    public void testAddAndGetCities() {
        service.addCity(new City(0, "Tokyo", 1));
        assertFalse(service.getCities().isEmpty());
    }

    @Test
    public void testGetCityById() {
        service.addCity(new City(0, "Tokyo", 1));
        City c = service.getCities().get(0);
        assertNotNull(service.getCityById(c.getId()));
    }

    @Test
    public void testGetCityByIdNotFound() {
        assertNull(service.getCityById(9999));
    }

    @Test
    public void testGetCitiesByDestinationId() {
        service.addCity(new City(0, "Kyoto", 2));
        service.addCity(new City(0, "Osaka", 2));
        assertTrue(service.getCitiesByDestinationId(2).size() >= 2);
    }

    @Test
    public void testDeleteCity() {
        service.addCity(new City(0, "Tokyo", 1));
        City c = service.getCities().get(0);
        service.deleteCity(c.getId());
        assertNull(service.getCityById(c.getId()));
    }
}