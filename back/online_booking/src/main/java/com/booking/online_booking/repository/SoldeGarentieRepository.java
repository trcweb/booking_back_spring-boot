package com.booking.online_booking.repository;

import com.booking.online_booking.model.SoldeGarentie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldeGarentieRepository extends JpaRepository<SoldeGarentie, Integer>{
    
}
