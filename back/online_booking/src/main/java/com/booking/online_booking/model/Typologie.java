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
public class Typologie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_typologie;
    private int nbr_lit;
    private String type_lit;
    private String designation;
    private int nbr_personnes;
}
