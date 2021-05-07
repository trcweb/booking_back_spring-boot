package com.booking.online_booking.model;

import java.sql.Date;

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
@Table(name = "reservation_hotel")
public class ReservationHotel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    private Integer id_reservation_hotel;
    @Expose
    private String description;
    @Expose
    private Date date_reservation;
    @Expose
    private Date date_arrive;
    @Expose
    private Date date_depart;
    @Expose
    private Integer duree_reservation;
    @ManyToOne
    @JoinColumn(name = "id_detailhotel")
    @Expose
    private DetailHotel detailHotel;
    @Expose
    private Double prix_total;
    @ManyToOne
    @JoinColumn(name = "id_paiement")
    @Expose
    private Paiement paiement;
    @ManyToOne
    @JoinColumn(name = "id_client")
    @Expose
    private Account client;
    

}
