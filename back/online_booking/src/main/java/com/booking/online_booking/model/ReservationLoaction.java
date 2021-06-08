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


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "reservation_location")
public class ReservationLoaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_reservation_location;
    @OneToOne
    @JoinColumn(name = "id_model")
    private ModelVehicule model;
    private String reservation;
    private Date date_reservation;
    private Date date_debut;
    private Date date_fin;
    private Double prix_totale;
    @OneToOne
    @JoinColumn(name = "id_paiement")
    private Paiement paiement;
    @ManyToOne
    @JoinColumn(name = "id_client")
    private Account client;
}
