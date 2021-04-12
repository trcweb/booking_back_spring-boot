package com.booking.online_booking.repository;

import com.booking.online_booking.model.UserAgence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAgenceRepository extends JpaRepository<UserAgence, Integer>{
    
}
