package com.example.myservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Attraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String description;
    private int cityId;

    public Attraction() {}

    public Attraction(int id, String nom, String description, int cityId) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.cityId = cityId;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getDescription() { return description; }
    public int getCityId() { return cityId; }

    public void setId(int id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setDescription(String description) { this.description = description; }
    public void setCityId(int cityId) { this.cityId = cityId; }
}