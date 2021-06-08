package com.booking.online_booking.repository;

import com.booking.online_booking.model.DetailHotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailHotelRepository extends JpaRepository<DetailHotel, Integer> {
    
}
