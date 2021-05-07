package com.booking.online_booking.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "reservation_location")
public class ReservationLoaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    private Integer id_reservation_location;
    @OneToOne
    @JoinColumn(name = "id_model")
    @Expose
    private ModelVehicule model;
    @Expose
    private String reservation;
    @Expose
    private Date date_reservation;
    @Expose
    private Date date_debut;
    @Expose
    private Date date_fin;
    @Expose
    private Double prix_totale;
    @OneToOne
    @JoinColumn(name = "id_paiement")
    @Expose
    private Paiement paiement;
    @ManyToOne
    @JoinColumn(name = "id_client")
    @Expose
    private Account client;
}
