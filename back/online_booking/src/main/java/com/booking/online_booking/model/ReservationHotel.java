package com.booking.online_booking.model;

import java.sql.Date;

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
@Table(name = "reservation_hotel")
public class ReservationHotel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_reservation_hotel;
    private String description;
    private Date date_reservation;
    private Date date_arrive;
    private Date date_depart;
    private Integer duree_reservation;
    @ManyToOne
    @JoinColumn(name = "id_detailhotel")
    private DetailHotel detailHotel;
    private Double prix_total;
    @ManyToOne
    @JoinColumn(name = "id_paiement")
    private Paiement paiement;
    @ManyToOne
    @JoinColumn(name = "id_client")
    private Account client;
    

}
