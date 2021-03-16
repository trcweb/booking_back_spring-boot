package com.booking.online_booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_hotel;
    private int nbr_etoile;
    private String nom;
    private String addresse;
    private String fix;
    private String fax;
    private String mobile;
    private String responsable_hotel;
    private String email_responsable;
    private String email_hotel;
    private String etat_hotel;
    
    public Hotel() {
    }

    public Hotel(Integer id_hotel, int nbr_etoile, String nom, String addresse, String fix, String fax, String mobile,
            String responsable_hotel, String email_responsable, String email_hotel, String etat_hotel) {
        this.id_hotel = id_hotel;
        this.nbr_etoile = nbr_etoile;
        this.nom = nom;
        this.addresse = addresse;
        this.fix = fix;
        this.fax = fax;
        this.mobile = mobile;
        this.responsable_hotel = responsable_hotel;
        this.email_responsable = email_responsable;
        this.email_hotel = email_hotel;
        this.etat_hotel = etat_hotel;
    }

    public Integer getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(Integer id_hotel) {
        this.id_hotel = id_hotel;
    }

    public int getNbr_etoile() {
        return nbr_etoile;
    }

    public void setNbr_etoile(int nbr_etoile) {
        this.nbr_etoile = nbr_etoile;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getFix() {
        return fix;
    }

    public void setFix(String fix) {
        this.fix = fix;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getResponsable_hotel() {
        return responsable_hotel;
    }

    public void setResponsable_hotel(String responsable_hotel) {
        this.responsable_hotel = responsable_hotel;
    }

    public String getEmail_responsable() {
        return email_responsable;
    }

    public void setEmail_responsable(String email_responsable) {
        this.email_responsable = email_responsable;
    }

    public String getEmail_hotel() {
        return email_hotel;
    }

    public void setEmail_hotel(String email_hotel) {
        this.email_hotel = email_hotel;
    }

    public String getEtat_hotel() {
        return etat_hotel;
    }

    public void setEtat_hotel(String etat_hotel) {
        this.etat_hotel = etat_hotel;
    }

}
