package com.booking.online_booking.repository;

import com.booking.online_booking.model.ModelVehicule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelVehiculeRepository extends JpaRepository<ModelVehicule, Integer>{
    
}
