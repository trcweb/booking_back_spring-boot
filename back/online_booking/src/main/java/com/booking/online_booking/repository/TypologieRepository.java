package com.booking.online_booking.repository;

import com.booking.online_booking.model.Typologie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypologieRepository extends JpaRepository<Typologie, Integer>{
    
}
