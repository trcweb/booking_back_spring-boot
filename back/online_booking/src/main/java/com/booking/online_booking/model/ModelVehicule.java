package com.booking.online_booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "model_vehicule")
public class ModelVehicule {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_model;
    @ManyToOne
    @JoinColumn(name = "id_agence_location")
    private AgenceLocation agenceLocation;
    @ManyToOne
    @JoinColumn(name = "id_categorie")
    private CategorieVehicule categorieVehicule;
    private boolean disponible;
    private String marque;
    private String model;
    private int capacite;
    private int nbr_porte;
    private boolean auto;
    private boolean climatise;

}
