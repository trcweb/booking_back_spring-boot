package com.booking.online_booking.model;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id_account;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;
    private String email;
    private String password;

    public Account() {
    }

    public Account(Integer id_account, Role role, String email, String password) {
        this.id_account = id_account;
        this.role = role;
        this.email = email;
        this.password = password;
    }

    public Integer getId_account() {
        return id_account;
    }

    public void setId_account(Integer id_account) {
        this.id_account = id_account;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
}
