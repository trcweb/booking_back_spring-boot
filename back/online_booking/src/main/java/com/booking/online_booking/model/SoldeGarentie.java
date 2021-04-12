package com.booking.online_booking.model;

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
@Table(name = "solde_garentie")
public class SoldeGarentie {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_garentie;

    @OneToOne
    @JoinColumn(name = "id_agence_account")
    private Account agence_account;
    private Double solde;
    private Double pourcentage_limite;
    private String type_paiement;
    @OneToOne
    @JoinColumn(name = "id_admin")
    private Account admin;
}
