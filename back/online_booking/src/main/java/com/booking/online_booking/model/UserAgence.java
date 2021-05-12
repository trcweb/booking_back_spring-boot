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
@Table(name = "user_agence")
public class UserAgence {
    
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
}
