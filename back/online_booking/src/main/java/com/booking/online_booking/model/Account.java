package com.booking.online_booking.model;

import javax.persistence.*;

import com.google.gson.annotations.Expose;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    private Integer id_account;

    @ManyToOne
    @JoinColumn(name = "id_role")
    @Expose
    private Role role;
    @Expose
    private String email;
    @Expose(serialize = false)
    private String password;
    @Column(name = "is_active")
    @Expose
    private boolean active;
    @Column(name = "refresh_token")
    @Expose
    private String refreshToken;     

    
}
