package com.example.myservice.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityTest {

    @Test
    public void testCityConstructor() {
        City city = new City(1, "Tokyo", 1);
        assertEquals(1, city.getId());
        assertEquals("Tokyo", city.getNom());
        assertEquals(1, city.getDestinationId());
    }

    @Test
    public void testCitySetters() {
        City city = new City(1, "Tokyo", 1);
        city.setId(2);
        city.setNom("Kyoto");
        city.setDestinationId(2);
        assertEquals(2, city.getId());
        assertEquals("Kyoto", city.getNom());
        assertEquals(2, city.getDestinationId());
    }
}
