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

    public Account() {
    }

    public Account(Integer id_account, Role role) {
        this.id_account = id_account;
        this.role = role;
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
    
    
}
