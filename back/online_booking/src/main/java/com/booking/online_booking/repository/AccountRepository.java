package com.booking.online_booking.repository;

import com.booking.online_booking.model.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    
    Account findByEmailAndActive(String email, boolean active);

    Account findByRefreshToken(String refreshToken);
    
    @Modifying
    @Query("update Account a set a.refreshToken = :token where a.id_account = :id")
    void setRefreshToken(@Param("id") Integer id, @Param("token") String token);

    @Modifying
    @Query("update Account a set a.refreshToken = :newToken where a.refreshToken = :token")
    void refreshToken(@Param("token") String token, @Param("newToken") String newToken);

    @Modifying
    @Query("update Account a set a.refreshToken = null where a.email = :email")
    void unvalidateToken(@Param("email") String email);
}
