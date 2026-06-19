package com.example.myservice.repositories;

import com.example.myservice.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findByDestinationId(int destinationId);
}
