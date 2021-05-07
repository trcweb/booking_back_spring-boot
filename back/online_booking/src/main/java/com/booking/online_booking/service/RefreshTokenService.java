package com.booking.online_booking.service;

import java.util.UUID;

import com.booking.online_booking.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefreshTokenService {
    
    @Autowired
    private AccountRepository accountRepository;

    public String creatRefreshToken(){
        return UUID.randomUUID().toString();
    }

    public void setRefreshToken(Integer id, String token){
        accountRepository.setRefreshToken(id, token);
    }

    public void refreshToken(String token, String newToken){
        accountRepository.refreshToken(token, newToken);
    }

    public void unvalidateRefreshToken(String email){
        accountRepository.unvalidateToken(email);
    }
}
