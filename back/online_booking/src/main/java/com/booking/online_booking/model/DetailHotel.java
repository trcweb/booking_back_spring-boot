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
@Table(name = "detail_hotel")
public class DetailHotel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    private Integer id_detailhotel;

    @ManyToOne
    @JoinColumn(name = "id_hotel")
    @Expose
    private Hotel hotel;
    @Expose
    private Date date_debut;
    @Expose
    private Date date_fin;
    @Expose
    private String detail_hotel;
}
