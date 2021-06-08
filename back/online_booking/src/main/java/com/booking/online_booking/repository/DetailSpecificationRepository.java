package com.booking.online_booking.repository;

import com.booking.online_booking.model.DetailSpecification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailSpecificationRepository extends JpaRepository<DetailSpecification, Integer> {
    
}
