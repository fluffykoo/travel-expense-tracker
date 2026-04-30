package com.example.myservice.controllers;

import com.example.myservice.entities.Destination;
import com.example.myservice.services.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class DestinationController {

    @Autowired
    DestinationService destinationService;

    @PostMapping("/destinations")
    public void addDestination(@RequestBody Destination destination) {
        destinationService.addDestination(destination);
    }

    @GetMapping("/destinations")
    public List<Destination> getDestinations() {
        return destinationService.getDestinations();
    }

    @GetMapping("/destinations/{id}")
    public Destination getDestinationById(@PathVariable int id) {
        return destinationService.getDestinationById(id);
    }

    @PutMapping("/destinations/{id}")
    public void updateStatut(@PathVariable int id, @RequestParam String statut) {
        destinationService.updateStatut(id, statut);
    }

    @DeleteMapping("/destinations/{id}")
    public void deleteDestination(@PathVariable int id) {
        destinationService.deleteDestination(id);
    }
}
