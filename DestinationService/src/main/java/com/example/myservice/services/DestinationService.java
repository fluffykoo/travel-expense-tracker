package com.example.myservice.services;

import com.example.myservice.entities.Destination;
import com.example.myservice.repositories.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    public void addDestination(Destination destination) {
        destinationRepository.save(destination);
    }

    public List<Destination> getDestinations() {
        return destinationRepository.findAll();
    }

    public Destination getDestinationById(int id) {
        return destinationRepository.findById(id).orElse(null);
    }

    public void updateStatut(int id, String statut) {
        Destination d = getDestinationById(id);
        if (d != null) {
            d.setStatut(statut);
            destinationRepository.save(d);
        }
    }

    public void deleteDestination(int id) {
        destinationRepository.deleteById(id);
    }
}