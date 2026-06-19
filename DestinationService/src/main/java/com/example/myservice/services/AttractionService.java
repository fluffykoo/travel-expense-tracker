package com.example.myservice.services;

import com.example.myservice.entities.Attraction;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttractionService {
    private List<Attraction> attractions = new ArrayList<>();

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public List<Attraction> getAttractionsByCityId(int cityId) {
        return attractions.stream()
                .filter(a -> a.getCityId() == cityId)
                .collect(Collectors.toList());
    }

    public Attraction getAttractionById(int id) {
        return attractions.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void deleteAttraction(int id) {
        attractions.removeIf(a -> a.getId() == id);
    }
}
