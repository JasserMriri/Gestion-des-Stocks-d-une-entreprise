package com.esprit.prodouih;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;

    private String nomP;

    private long prix;

    private long quantite;


    // Constructor with parameters
    public Produit(String nomP, long prix, long quantite) {
        this.nomP = nomP;
        this.prix = prix;
        this.quantite = quantite;
    }

    // No-argument constructor (needed for JPA)
    public Produit() {
    }

    // Getter and Setter for idProduit
    public Long getIdProduit() { // Corrected return type to Long
        return idProduit;
    }

    public void setIdProduit(Long idProduit) { // Corrected parameter type to Long
        this.idProduit = idProduit;
    }

    // Getter and Setter for nomP
    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    // Getter and Setter for prix
    public long getPrix() {
        return prix;
    }

    public void setPrix(long prix) {
        this.prix = prix;
    }

    // Getter and Setter for quantite
    public long getQuantite() {
        return quantite;
    }

    public void setQuantite(long quantite) {
        this.quantite = quantite;
    }
}
