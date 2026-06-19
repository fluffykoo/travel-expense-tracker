package com.example.myservice.services;

import com.example.myservice.entities.Destination;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DestinationServiceTest {

    @Autowired
    private DestinationService service;

    @Test
    public void testAddAndGetDestinations() {
        service.addDestination(new Destination(0, "Japon", "A_VISITER"));
        assertFalse(service.getDestinations().isEmpty());
    }

    @Test
    public void testGetDestinationById() {
        service.addDestination(new Destination(0, "Japon", "A_VISITER"));
        Destination d = service.getDestinations().get(0);
        assertNotNull(service.getDestinationById(d.getId()));
    }

    @Test
    public void testGetDestinationByIdNotFound() {
        assertNull(service.getDestinationById(9999));
    }

    @Test
    public void testUpdateStatut() {
        service.addDestination(new Destination(0, "Japon", "A_VISITER"));
        Destination d = service.getDestinations().get(0);
        service.updateStatut(d.getId(), "VISITE");
        assertEquals("VISITE", service.getDestinationById(d.getId()).getStatut());
    }

    @Test
    public void testDeleteDestination() {
        service.addDestination(new Destination(0, "Japon", "A_VISITER"));
        Destination d = service.getDestinations().get(0);
        service.deleteDestination(d.getId());
        assertNull(service.getDestinationById(d.getId()));
    }
}