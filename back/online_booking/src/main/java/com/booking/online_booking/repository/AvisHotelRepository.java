package com.booking.online_booking.repository;

import com.booking.online_booking.model.AvisHotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvisHotelRepository extends JpaRepository<AvisHotel, Integer>{
    
}
