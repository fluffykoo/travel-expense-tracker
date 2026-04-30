package com.example.myservice.entities;

public class City {
    private int id;
    private String nom;
    private int destinationId;

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
