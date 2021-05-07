package com.booking.online_booking.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.google.gson.annotations.Expose;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Paiement {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    private Integer id_paiement;

    @OneToOne
    @JoinColumn(name = "id_facture")
    @Expose
    private Facture facture;
    @Expose
    private String mode_paiement;
    @Expose
    private Date date_paiement;
    @Expose
    private Double montant;
}
