package com.booking.online_booking.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_hotel;
    private int nbr_etoile;
    private String nom;
    private String addresse;
    private String pays;
    private String ville_code_iata;
    private String fix;
    private String fax;
    private String mobile;
    private String responsable_hotel;
    private String email_responsable;
    private String email_hotel;
    private String etat_hotel;

    public boolean filterByStars(List<Integer> listStars){
        return listStars.contains(nbr_etoile);
    }

}
