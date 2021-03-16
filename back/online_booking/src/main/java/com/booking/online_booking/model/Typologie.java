package com.booking.online_booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Typologie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_typologie;
    private int nbr_lit;
    private String type_lit;
    private String designation;

    public Typologie() {
    }

    public Typologie(Integer id_typologie, int nbr_lit, String type_lit, String designation) {
        this.id_typologie = id_typologie;
        this.nbr_lit = nbr_lit;
        this.type_lit = type_lit;
        this.designation = designation;
    }

    public Integer getId_typologie() {
        return id_typologie;
    }

    public void setId_typologie(Integer id_typologie) {
        this.id_typologie = id_typologie;
    }

    public int getNbr_lit() {
        return nbr_lit;
    }

    public void setNbr_lit(int nbr_lit) {
        this.nbr_lit = nbr_lit;
    }

    public String getType_lit() {
        return type_lit;
    }

    public void setType_lit(String type_lit) {
        this.type_lit = type_lit;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

}
