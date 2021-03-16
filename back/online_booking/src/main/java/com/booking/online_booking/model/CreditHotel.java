package com.booking.online_booking.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "credit_hotel")
public class CreditHotel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_credith;
    @OneToOne
    @JoinColumn(name = "id_solde")
    private SoldeGarentie garentie;
    private Double solde;
    private Date date;
    private String type;
    
    public CreditHotel() {
    }

    public CreditHotel(Integer id_credith, SoldeGarentie garentie, Double solde, Date date, String type) {
        this.id_credith = id_credith;
        this.garentie = garentie;
        this.solde = solde;
        this.date = date;
        this.type = type;
    }

    public Integer getId_credith() {
        return id_credith;
    }

    public void setId_credith(Integer id_credith) {
        this.id_credith = id_credith;
    }

    public SoldeGarentie getGarentie() {
        return garentie;
    }

    public void setGarentie(SoldeGarentie garentie) {
        this.garentie = garentie;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
}
