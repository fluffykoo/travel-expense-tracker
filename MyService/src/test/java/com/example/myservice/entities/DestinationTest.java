package com.example.myservice.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DestinationTest {

    @Test
    public void testDestinationConstructor() {
        Destination destination = new Destination(1, "Japon", "A_VISITER");
        assertEquals(1, destination.getId());
        assertEquals("Japon", destination.getPays());
        assertEquals("A_VISITER", destination.getStatut());
    }

    @Test
    public void testDestinationSetters() {
        Destination destination = new Destination(1, "Japon", "A_VISITER");
        destination.setId(2);
        destination.setPays("France");
        destination.setStatut("VISITE");
        assertEquals(2, destination.getId());
        assertEquals("France", destination.getPays());
        assertEquals("VISITE", destination.getStatut());
    }
}
