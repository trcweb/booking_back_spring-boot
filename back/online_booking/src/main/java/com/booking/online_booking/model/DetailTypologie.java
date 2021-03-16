package com.booking.online_booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detail_typologie")
public class DetailTypologie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_detailtypologie;

    @ManyToOne
    @JoinColumn(name = "id_detailhotel")
    private DetailHotel detailHotel; 

    @ManyToOne
    @JoinColumn(name = "id_typologie")
    private Typologie typologie;

    private Double prix_typologie;

    public DetailTypologie() {
    }

    public DetailTypologie(Integer id_detailtypologie, DetailHotel detailHotel, Typologie typologie,
            Double prix_typologie) {
        this.id_detailtypologie = id_detailtypologie;
        this.detailHotel = detailHotel;
        this.typologie = typologie;
        this.prix_typologie = prix_typologie;
    }

    public Integer getId_detailtypologie() {
        return id_detailtypologie;
    }

    public void setId_detailtypologie(Integer id_detailtypologie) {
        this.id_detailtypologie = id_detailtypologie;
    }

    public DetailHotel getDetailHotel() {
        return detailHotel;
    }

    public void setDetailHotel(DetailHotel detailHotel) {
        this.detailHotel = detailHotel;
    }

    public Typologie getTypologie() {
        return typologie;
    }

    public void setTypologie(Typologie typologie) {
        this.typologie = typologie;
    }

    public Double getPrix_typologie() {
        return prix_typologie;
    }

    public void setPrix_typologie(Double prix_typologie) {
        this.prix_typologie = prix_typologie;
    }
}
