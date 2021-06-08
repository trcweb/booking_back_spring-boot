package com.booking.online_booking.repository;

import com.booking.online_booking.model.Logement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogementRepository extends JpaRepository<Logement, Integer>{
    
}
