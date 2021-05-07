package com.booking.online_booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "agence_location")
public class AgenceLocation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    private Integer id_agence_location;
    @Expose
    private String registre_commerce;
    @Expose
    private String raison_social;
    @Expose
    private String addresse;
    @Expose
    private String mobile;
    @Expose
    private String ville_code_iata;

}
