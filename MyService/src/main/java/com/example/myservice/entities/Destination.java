package com.example.myservice.entities;

public class Destination {
    private int id;
    private String pays;
    private String statut; // "A_VISITER" ou "VISITE"

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
