package com.booking.online_booking.model;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_account;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;
    private String email;
    private String password;
    @Column(name = "is_active")
    private boolean active;       

    
}
