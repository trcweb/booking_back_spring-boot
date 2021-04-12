package com.booking.online_booking.repository;

import com.booking.online_booking.model.Paiement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Integer>{
    
}
