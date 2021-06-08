package com.booking.online_booking.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "avis_hotel")
public class AvisHotel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_avis;
    @ManyToOne
    @JoinColumn(name = "id_resident")
    private Account resident;
    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;
    private Date date_avis;
    private String avis;
    private int rating;
}
