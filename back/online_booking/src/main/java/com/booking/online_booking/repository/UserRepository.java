package com.booking.online_booking.repository;

import com.booking.online_booking.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
    
    @Query(value = "SELECT u.* FROM users u inner join account a on a.id_account = u.id_account WHERE a.email = :email ", nativeQuery = true)
    User findByAccountEmail(@Param("email") String email);
}
