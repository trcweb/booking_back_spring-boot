package com.booking.online_booking.repository;

import com.booking.online_booking.model.AgenceLocation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenceLocationRepository extends JpaRepository<AgenceLocation, Integer> {
    
}
