package com.booking.online_booking.model;

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
@Table(name = "detail_logement")
public class DetailLogement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_detaillogement;

    @ManyToOne
    @JoinColumn(name = "id_detailhotel")
    private DetailHotel detailHotel;

    @ManyToOne
    @JoinColumn(name = "id_logement")
    private Logement logement;
    private Double prix_logement;
}
