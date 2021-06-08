package com.booking.online_booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Airliner {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_airliner;
    private String nom;
    private String code_iata;
    private String email;
    private String tel;
}
