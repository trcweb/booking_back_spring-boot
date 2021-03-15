package com.booking.online_booking.model;


import java.sql.Date;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class User {

    @Id
    private String cin;
    
    private String num_passport;

    private String name;

    private String lastname;

    private Date date_naissance;

    @OneToOne
    @JoinColumn(name = "id_account")
    private Account account;
}
