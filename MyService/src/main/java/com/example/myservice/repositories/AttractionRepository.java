package com.example.myservice.repositories;

import com.example.myservice.entities.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AttractionRepository extends JpaRepository<Attraction, Integer> {
    List<Attraction> findByCityId(int cityId);
}
