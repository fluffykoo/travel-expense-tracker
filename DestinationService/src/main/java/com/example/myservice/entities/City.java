package com.example.myservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private int destinationId;

    public City() {}

    public City(int id, String nom, int destinationId) {
        this.id = id;
        this.nom = nom;
        this.destinationId = destinationId;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public int getDestinationId() { return destinationId; }

    public void setId(int id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setDestinationId(int destinationId) { this.destinationId = destinationId; }
}