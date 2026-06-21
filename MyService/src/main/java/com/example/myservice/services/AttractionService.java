package com.example.myservice.services;

import com.example.myservice.entities.Attraction;
import com.example.myservice.repositories.AttractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AttractionService {

    @Autowired
    private AttractionRepository attractionRepository;

    public void addAttraction(Attraction attraction) {
        attractionRepository.save(attraction);
    }

    public List<Attraction> getAttractions() {
        return attractionRepository.findAll();
    }

    public List<Attraction> getAttractionsByCityId(int cityId) {
        return attractionRepository.findAll().stream()
                .filter(a -> a.getCityId() == cityId)
                .collect(Collectors.toList());
    }

    public Attraction getAttractionById(int id) {
        return attractionRepository.findById(id).orElse(null);
    }

    public void deleteAttraction(int id) {
        attractionRepository.deleteById(id);
    }
}
