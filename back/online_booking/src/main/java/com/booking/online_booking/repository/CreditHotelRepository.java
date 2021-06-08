package com.booking.online_booking.repository;

import com.booking.online_booking.model.CreditHotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditHotelRepository extends JpaRepository<CreditHotel, Integer> {
    
}
