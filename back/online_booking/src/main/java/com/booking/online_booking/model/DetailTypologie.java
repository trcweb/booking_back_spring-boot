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
@Table(name = "detail_typologie")
public class DetailTypologie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    private Integer id_detailtypologie;

    @ManyToOne
    @JoinColumn(name = "id_detailhotel")
    @Expose
    private DetailHotel detailHotel; 

    @ManyToOne
    @JoinColumn(name = "id_typologie")
    @Expose
    private Typologie typologie;
    @Expose
    private Double prix_typologie;

    public boolean filterByPriceRange(int start, int end){
        return prix_typologie >= start && prix_typologie <= end ;
    }
}
