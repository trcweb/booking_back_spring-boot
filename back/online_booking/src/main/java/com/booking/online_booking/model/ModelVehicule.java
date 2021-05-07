package com.booking.online_booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "model_vehicule")
public class ModelVehicule {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    private Integer id_model;
    @ManyToOne
    @JoinColumn(name = "id_agence_location")
    @Expose
    private AgenceLocation agenceLocation;
    @ManyToOne
    @JoinColumn(name = "id_categorie")
    @Expose
    private CategorieVehicule categorieVehicule;
    @Expose
    private boolean disponible;
    @Expose
    private String marque;
    @Expose
    private String model;
    @Expose
    private int capacite;
    @Expose
    private int nbr_porte;
    @Expose
    private boolean auto;
    @Expose
    private boolean climatise;

}
