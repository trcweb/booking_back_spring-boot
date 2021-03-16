package com.booking.online_booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "solde_garentie")
public class SoldeGarentie {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_garentie;

    @OneToOne
    @JoinColumn(name = "id_agence")
    private Account agence;
    private Double solde;
    private Double pourcentage_limite;
    private String type_paiement;
    @OneToOne
    @JoinColumn(name = "id_admin")
    private Account admin;

    
    public SoldeGarentie() {
    }


    public SoldeGarentie(Integer id_garentie, Account agence, Double solde, Double pourcentage_limite,
            String type_paiement, Account admin) {
        this.id_garentie = id_garentie;
        this.agence = agence;
        this.solde = solde;
        this.pourcentage_limite = pourcentage_limite;
        this.type_paiement = type_paiement;
        this.admin = admin;
    }


    public Integer getId_garentie() {
        return id_garentie;
    }


    public void setId_garentie(Integer id_garentie) {
        this.id_garentie = id_garentie;
    }


    public Account getAgence() {
        return agence;
    }


    public void setAgence(Account agence) {
        this.agence = agence;
    }


    public Double getSolde() {
        return solde;
    }


    public void setSolde(Double solde) {
        this.solde = solde;
    }


    public Double getPourcentage_limite() {
        return pourcentage_limite;
    }


    public void setPourcentage_limite(Double pourcentage_limite) {
        this.pourcentage_limite = pourcentage_limite;
    }


    public String getType_paiement() {
        return type_paiement;
    }


    public void setType_paiement(String type_paiement) {
        this.type_paiement = type_paiement;
    }


    public Account getAdmin() {
        return admin;
    }


    public void setAdmin(Account admin) {
        this.admin = admin;
    }
    
}
