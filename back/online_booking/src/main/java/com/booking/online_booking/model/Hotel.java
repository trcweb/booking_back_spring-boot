package com.booking.online_booking.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.gson.annotations.Expose;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    private Integer id_hotel;
    @Expose
    private int nbr_etoile;
    @Expose
    private String nom;
    @Expose
    private String addresse;
    @Expose
    private String pays;
    @Expose
    private String ville_code_iata;
    @Expose
    private String fix;
    @Expose
    private String fax;
    @Expose
    private String mobile;
    @Expose
    private String responsable_hotel;
    @Expose
    private String email_responsable;
    @Expose
    private String email_hotel;
    @Expose
    private String etat_hotel;

    public boolean filterByStars(List<Integer> listStars){
        return listStars.contains(nbr_etoile);
    }

}
