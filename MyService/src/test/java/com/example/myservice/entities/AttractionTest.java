package com.example.myservice.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AttractionTest {

    @Test
    public void testAttractionConstructor() {
        Attraction attraction = new Attraction(1, "Tour de Tokyo", "Grande tour", 1);
        assertEquals(1, attraction.getId());
        assertEquals("Tour de Tokyo", attraction.getNom());
        assertEquals("Grande tour", attraction.getDescription());
        assertEquals(1, attraction.getCityId());
    }

    @Test
    public void testAttractionSetters() {
        Attraction attraction = new Attraction(1, "Tour de Tokyo", "Grande tour", 1);
        attraction.setId(2);
        attraction.setNom("Shibuya");
        attraction.setDescription("Carrefour celebre");
        attraction.setCityId(2);
        assertEquals(2, attraction.getId());
        assertEquals("Shibuya", attraction.getNom());
        assertEquals("Carrefour celebre", attraction.getDescription());
        assertEquals(2, attraction.getCityId());
    }
}
