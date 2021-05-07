package com.booking.online_booking.model;

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
@Table(name = "user_agence")
public class UserAgence {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    private Integer id_agence;

    @OneToOne
    @JoinColumn(name = "id_account")
    @Expose(serialize = false)
    private Account account;
    @Expose
    private String matricule_fiscale;
    @Expose
    private String registre_commerce;
    @Expose
    private String raison_social;
    @Expose
    private String adresse_agence;
    @Expose
    private String mobile_agence;
}
