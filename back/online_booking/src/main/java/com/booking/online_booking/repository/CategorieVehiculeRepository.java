package com.booking.online_booking.repository;

import com.booking.online_booking.model.CategorieVehicule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieVehiculeRepository extends JpaRepository<CategorieVehicule, Integer> {
    
}
