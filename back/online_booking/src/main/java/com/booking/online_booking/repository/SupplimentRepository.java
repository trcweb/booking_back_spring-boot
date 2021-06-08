package com.booking.online_booking.repository;

import com.booking.online_booking.model.Suppliment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplimentRepository extends JpaRepository<Suppliment, Integer>{
    
}
