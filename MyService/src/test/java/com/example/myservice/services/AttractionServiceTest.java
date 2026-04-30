package com.example.myservice.services;

import com.example.myservice.entities.Attraction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AttractionServiceTest {

    @Test
    public void testAddAndGetAttractions() {
        AttractionService service = new AttractionService();
        service.addAttraction(new Attraction(1, "Tour de Tokyo", "Grande tour", 1));
        assertEquals(1, service.getAttractions().size());
    }

    @Test
    public void testGetAttractionById() {
        AttractionService service = new AttractionService();
        service.addAttraction(new Attraction(1, "Tour de Tokyo", "Grande tour", 1));
        assertNotNull(service.getAttractionById(1));
        assertEquals("Tour de Tokyo", service.getAttractionById(1).getNom());
    }

    @Test
    public void testGetAttractionByIdNotFound() {
        AttractionService service = new AttractionService();
        assertNull(service.getAttractionById(99));
    }

    @Test
    public void testGetAttractionsByCityId() {
        AttractionService service = new AttractionService();
        service.addAttraction(new Attraction(1, "Tour de Tokyo", "Grande tour", 1));
        service.addAttraction(new Attraction(2, "Shibuya", "Carrefour", 1));
        service.addAttraction(new Attraction(3, "Eiffel", "Tour", 2));
        assertEquals(2, service.getAttractionsByCityId(1).size());
    }

    @Test
    public void testDeleteAttraction() {
        AttractionService service = new AttractionService();
        service.addAttraction(new Attraction(1, "Tour de Tokyo", "Grande tour", 1));
        service.deleteAttraction(1);
        assertEquals(0, service.getAttractions().size());
    }
}
