package com.booking.online_booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Agence {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_agence;

    @OneToOne
    @JoinColumn(name = "id_account")
    private Account account;

    private String matricule_fiscale;
    private String registre_commerce;
    private String raison_social;
    private String adresse_agence;
    private String mobile_agence;
    
    public Agence() {
    }

    public Agence(Integer id_agence, Account account, String matricule_fiscale, String registre_commerce,
            String raison_social, String adresse_agence, String mobile_agence) {
        this.id_agence = id_agence;
        this.account = account;
        this.matricule_fiscale = matricule_fiscale;
        this.registre_commerce = registre_commerce;
        this.raison_social = raison_social;
        this.adresse_agence = adresse_agence;
        this.mobile_agence = mobile_agence;
    }

    public Integer getId_agence() {
        return id_agence;
    }

    public void setId_agence(Integer id_agence) {
        this.id_agence = id_agence;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getMatricule_fiscale() {
        return matricule_fiscale;
    }

    public void setMatricule_fiscale(String matricule_fiscale) {
        this.matricule_fiscale = matricule_fiscale;
    }

    public String getRegistre_commerce() {
        return registre_commerce;
    }

    public void setRegistre_commerce(String registre_commerce) {
        this.registre_commerce = registre_commerce;
    }

    public String getRaison_social() {
        return raison_social;
    }

    public void setRaison_social(String raison_social) {
        this.raison_social = raison_social;
    }

    public String getAdresse_agence() {
        return adresse_agence;
    }

    public void setAdresse_agence(String adresse_agence) {
        this.adresse_agence = adresse_agence;
    }

    public String getMobile_agence() {
        return mobile_agence;
    }

    public void setMobile_agence(String mobile_agence) {
        this.mobile_agence = mobile_agence;
    }

    
}
