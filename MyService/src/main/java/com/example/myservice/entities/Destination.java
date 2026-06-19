package com.example.myservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String pays;
    private String statut;

    public Destination() {}

    public Destination(int id, String pays, String statut) {
        this.id = id;
        this.pays = pays;
        this.statut = statut;
    }

    public int getId() { return id; }
    public String getPays() { return pays; }
    public String getStatut() { return statut; }

    public void setId(int id) { this.id = id; }
    public void setPays(String pays) { this.pays = pays; }
    public void setStatut(String statut) { this.statut = statut; }
}