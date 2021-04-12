package com.booking.online_booking.repository;

import com.booking.online_booking.model.CreditBilletrie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditBilletrieRepository extends JpaRepository<CreditBilletrie, Integer> {
    
}
