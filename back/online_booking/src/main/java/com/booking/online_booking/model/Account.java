package com.booking.online_booking.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

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
    @Email
    @NotEmpty
    private String email;
    @NotEmpty
    @Pattern(message = "password must be 8 char long and contain at least 1 uppercase, 1 lowercase, 1 digit", 
             regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")
    private String password;
    @Column(name = "is_active")
    private boolean active;
    @Column(name = "refresh_token")
    private String refreshToken;   

    
}
