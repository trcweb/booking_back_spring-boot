package com.booking.online_booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "agence_location")
public class AgenceLocation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_agence_location;
    private String registre_commerce;
    private String raison_social;
    private String addresse;
    private String mobile;
    private String ville_code_iata;

}
