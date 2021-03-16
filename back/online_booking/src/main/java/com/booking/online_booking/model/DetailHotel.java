package com.booking.online_booking.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detail_hotel")
public class DetailHotel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_detailhotel;

    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;
    private Date date_debut;
    private Date date_fin;
    private String detail_hotel;
    
    public DetailHotel() {
    }

    public DetailHotel(Integer id_detailhotel, Hotel hotel, Date date_debut, Date date_fin, String detail_hotel) {
        this.id_detailhotel = id_detailhotel;
        this.hotel = hotel;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.detail_hotel = detail_hotel;
    }

    public Integer getId_detailhotel() {
        return id_detailhotel;
    }

    public void setId_detailhotel(Integer id_detailhotel) {
        this.id_detailhotel = id_detailhotel;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public String getDetail_hotel() {
        return detail_hotel;
    }

    public void setDetail_hotel(String detail_hotel) {
        this.detail_hotel = detail_hotel;
    }
    
}
