package com.booking.online_booking.repository;

import com.booking.online_booking.model.ReservationLoaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationLoactionRepository extends JpaRepository<ReservationLoaction, Integer>{
    
}
