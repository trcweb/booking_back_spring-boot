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
public class Logement {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_logement;
    private String logement;
}
