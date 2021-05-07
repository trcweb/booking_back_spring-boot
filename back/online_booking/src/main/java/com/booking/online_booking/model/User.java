package com.booking.online_booking.model;


import java.sql.Date;

import javax.persistence.Entity;
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
@Table(name = "users")
public class User {

    @Id
    @Expose
    private String cin;
    @Expose
    private String num_passport;
    @Expose
    private String name;
    @Expose
    private String lastname;
    @Expose
    private Date date_naissance;

    @OneToOne
    @JoinColumn(name = "id_account")
    @Expose
    private Account account;
}
