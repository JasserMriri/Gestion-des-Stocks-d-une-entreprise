package com.esprit.microservice.projetfactures;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
@Entity
public class Facture implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idF;
    private String code;
    private String adresse;
    private String tel;
    private String email;
    private String refrence;
    private float prix;
    private int quantite;

    public Long getIdF() {
        return idF;
    }

    public void setIdF(Long idF) {
        this.idF = idF;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRefrence() {
        return refrence;
    }

    public void setRefrence(String refrence) {
        this.refrence = refrence;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Facture() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Facture(String code, String adresse, String tel, String email, String refrence, float prix, int quantite) {
        super();
        this.code = code;
        this.adresse = adresse;
        this.tel = tel;
        this.email = email;
        this.refrence = refrence;
        this.prix = prix;
        this.quantite = quantite;
    }
    public Facture(String adresse, String tel, String email) {
        super();
        this.adresse = adresse;
        this.tel = tel;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Facture [id=" + idF + ", code=" + code + ", adresse=" + adresse + ", tel=" + tel + ", email=" + email
                + ", refrence=" + refrence + ", prix=" + prix + ", quantite=" + quantite + "]";
    }

}
