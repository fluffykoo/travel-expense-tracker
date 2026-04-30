package com.example.myservice.entities;

public class Expense {
    private int id;
    private double montant;
    private String categorie; // HOTEL, TRANSPORT, NOURRITURE, ACTIVITE
    private String description;
    private int destinationId;

    public Expense(int id, double montant, String categorie, String description, int destinationId) {
        this.id = id;
        this.montant = montant;
        this.categorie = categorie;
        this.description = description;
        this.destinationId = destinationId;
    }

    public int getId() { return id; }
    public double getMontant() { return montant; }
    public String getCategorie() { return categorie; }
    public String getDescription() { return description; }
    public int getDestinationId() { return destinationId; }

    public void setId(int id) { this.id = id; }
    public void setMontant(double montant) { this.montant = montant; }
    public void setCategorie(String categorie) { this.categorie = categorie; }
    public void setDescription(String description) { this.description = description; }
    public void setDestinationId(int destinationId) { this.destinationId = destinationId; }
}

