package com.booking.online_booking.repository;

import com.booking.online_booking.model.UserAgence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAgenceRepository extends JpaRepository<UserAgence, Integer>{
    
    @Query(value = "SELECT u.* FROM user_agence u inner join account a on a.id_account = u.id_account WHERE a.email = :name ", nativeQuery = true)
    UserAgence findByAccountEmail(@Param("name") String username);
}
