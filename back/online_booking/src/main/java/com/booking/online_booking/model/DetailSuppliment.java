package com.booking.online_booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "detail_suppliment")
public class DetailSuppliment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    private Integer id_detailsuppliment;

    @ManyToOne
    @JoinColumn(name = "id_detailhotel")
    @Expose
    private DetailHotel detailHotel;

    @ManyToOne
    @JoinColumn(name = "id_suppliment")
    @Expose
    private Suppliment suppliment;
    @Expose
    private Double prix_suppliment;

}
