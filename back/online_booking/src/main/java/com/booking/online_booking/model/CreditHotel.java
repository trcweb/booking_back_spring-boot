package com.booking.online_booking.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "credit_hotel")
public class CreditHotel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    private Integer id_credith;
    @OneToOne
    @JoinColumn(name = "id_solde")
    @Expose
    private SoldeGarentie garentie;
    @Expose
    private Double solde;
    @Expose
    private Date date;
    @Expose
    private String type;    
}
