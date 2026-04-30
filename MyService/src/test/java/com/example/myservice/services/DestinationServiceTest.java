package com.example.myservice.services;

import com.example.myservice.entities.Destination;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DestinationServiceTest {

    @Test
    public void testAddAndGetDestinations() {
        DestinationService service = new DestinationService();
        service.addDestination(new Destination(1, "Japon", "A_VISITER"));
        assertEquals(1, service.getDestinations().size());
    }

    @Test
    public void testGetDestinationById() {
        DestinationService service = new DestinationService();
        service.addDestination(new Destination(1, "Japon", "A_VISITER"));
        assertNotNull(service.getDestinationById(1));
        assertEquals("Japon", service.getDestinationById(1).getPays());
    }

    @Test
    public void testGetDestinationByIdNotFound() {
        DestinationService service = new DestinationService();
        assertNull(service.getDestinationById(99));
    }

    @Test
    public void testUpdateStatut() {
        DestinationService service = new DestinationService();
        service.addDestination(new Destination(1, "Japon", "A_VISITER"));
        service.updateStatut(1, "VISITE");
        assertEquals("VISITE", service.getDestinationById(1).getStatut());
    }

    @Test
    public void testDeleteDestination() {
        DestinationService service = new DestinationService();
        service.addDestination(new Destination(1, "Japon", "A_VISITER"));
        service.deleteDestination(1);
        assertEquals(0, service.getDestinations().size());
    }
}
