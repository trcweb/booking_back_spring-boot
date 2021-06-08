package com.booking.online_booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
    @NotNull
    @Valid
    private Account account;
    @NotEmpty
    private String matricule_fiscale;
    @NotEmpty
    private String registre_commerce;
    @NotEmpty
    private String raison_social;
    @NotEmpty
    private String adresse_agence;
    @NotEmpty
    private String mobile_agence;
}
