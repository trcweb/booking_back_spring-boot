package com.booking.online_booking.repository;

import com.booking.online_booking.model.CreditVoiture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrediVoitureRepository extends JpaRepository<CreditVoiture, Integer> {
    
}
