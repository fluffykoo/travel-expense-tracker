package com.example.myservice.services;

import com.example.myservice.entities.City;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityServiceTest {

    @Test
    public void testAddAndGetCities() {
        CityService service = new CityService();
        service.addCity(new City(1, "Tokyo", 1));
        assertEquals(1, service.getCities().size());
    }

    @Test
    public void testGetCityById() {
        CityService service = new CityService();
        service.addCity(new City(1, "Tokyo", 1));
        assertNotNull(service.getCityById(1));
        assertEquals("Tokyo", service.getCityById(1).getNom());
    }

    @Test
    public void testGetCityByIdNotFound() {
        CityService service = new CityService();
        assertNull(service.getCityById(99));
    }

    @Test
    public void testGetCitiesByDestinationId() {
        CityService service = new CityService();
        service.addCity(new City(1, "Tokyo", 1));
        service.addCity(new City(2, "Kyoto", 1));
        service.addCity(new City(3, "Paris", 2));
        assertEquals(2, service.getCitiesByDestinationId(1).size());
    }

    @Test
    public void testDeleteCity() {
        CityService service = new CityService();
        service.addCity(new City(1, "Tokyo", 1));
        service.deleteCity(1);
        assertEquals(0, service.getCities().size());
    }
}
