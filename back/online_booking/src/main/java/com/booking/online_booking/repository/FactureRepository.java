package com.booking.online_booking.repository;

import com.booking.online_booking.model.Facture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Integer>{
    
}
