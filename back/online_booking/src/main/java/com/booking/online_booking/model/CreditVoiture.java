package com.booking.online_booking.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "credit_voiture")
public class CreditVoiture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_creditv;
    @OneToOne
    @JoinColumn(name = "id_solde")
    private SoldeGarentie garentie;
    private Double solde;
    private Date date;
    private String type;
    
}
