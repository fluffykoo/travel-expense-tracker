package com.example.myservice.controllers;

import com.example.myservice.entities.Attraction;
import com.example.myservice.services.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AttractionController {

    @Autowired
    AttractionService attractionService;

    @PostMapping("/attractions")
    public void addAttraction(@RequestBody Attraction attraction) {
        attractionService.addAttraction(attraction);
    }

    @GetMapping("/attractions")
    public List<Attraction> getAttractions() {
        return attractionService.getAttractions();
    }

    @GetMapping("/attractions/{id}")
    public Attraction getAttractionById(@PathVariable int id) {
        return attractionService.getAttractionById(id);
    }

    @GetMapping("/attractions/city/{cityId}")
    public List<Attraction> getAttractionsByCity(@PathVariable int cityId) {
        return attractionService.getAttractionsByCityId(cityId);
    }

    @DeleteMapping("/attractions/{id}")
    public void deleteAttraction(@PathVariable int id) {
        attractionService.deleteAttraction(id);
    }
}
