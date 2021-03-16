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

    public User() {
    }

    public User(String cin, String num_passport, String name, String lastname, Date date_naissance, Account account) {
        this.cin = cin;
        this.num_passport = num_passport;
        this.name = name;
        this.lastname = lastname;
        this.date_naissance = date_naissance;
        this.account = account;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNum_passport() {
        return num_passport;
    }

    public void setNum_passport(String num_passport) {
        this.num_passport = num_passport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
