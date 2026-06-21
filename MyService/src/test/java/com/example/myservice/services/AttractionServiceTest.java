package com.example.myservice.services;

import com.example.myservice.entities.Attraction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AttractionServiceTest {

    @Autowired
    private AttractionService service;

    @Test
    public void testAddAndGetAttractions() {
        service.addAttraction(new Attraction(0, "Tour de Tokyo", "Grande tour", 1));
        assertFalse(service.getAttractions().isEmpty());
    }

    @Test
    public void testGetAttractionById() {
        service.addAttraction(new Attraction(0, "Tour de Tokyo", "Grande tour", 1));
        Attraction a = service.getAttractions().get(0);
        assertNotNull(service.getAttractionById(a.getId()));
    }

    @Test
    public void testGetAttractionByIdNotFound() {
        assertNull(service.getAttractionById(9999));
    }

    @Test
    public void testGetAttractionsByCityId() {
        service.addAttraction(new Attraction(0, "Shibuya", "Carrefour", 2));
        service.addAttraction(new Attraction(0, "Senso-ji", "Temple", 2));
        assertTrue(service.getAttractionsByCityId(2).size() >= 2);
    }

    @Test
    public void testDeleteAttraction() {
        service.addAttraction(new Attraction(0, "Tour de Tokyo", "Grande tour", 1));
        Attraction a = service.getAttractions().get(0);
        service.deleteAttraction(a.getId());
        assertNull(service.getAttractionById(a.getId()));
    }
}