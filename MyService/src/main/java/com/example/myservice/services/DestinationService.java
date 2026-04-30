package com.example.myservice.services;

import com.example.myservice.entities.Destination;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DestinationService {
    private List<Destination> destinations = new ArrayList<>();

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public Destination getDestinationById(int id) {
        return destinations.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void updateStatut(int id, String statut) {
        Destination d = getDestinationById(id);
        if (d != null) d.setStatut(statut);
    }

    public void deleteDestination(int id) {
        destinations.removeIf(d -> d.getId() == id);
    }
}
