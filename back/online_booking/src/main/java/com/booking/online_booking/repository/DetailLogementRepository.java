package com.booking.online_booking.repository;

import com.booking.online_booking.model.DetailLogement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailLogementRepository extends JpaRepository<DetailLogement, Integer> {
    
}
