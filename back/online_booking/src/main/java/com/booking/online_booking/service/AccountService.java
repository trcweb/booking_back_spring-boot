package com.booking.online_booking.service;

import com.booking.online_booking.model.Account;
import com.booking.online_booking.repository.AccountRepository;
import com.booking.online_booking.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    
    public final String CLIENT = "CLIENT";
    public final String ADMIN = "ADMIN";
    public final String AGENCE = "AGENCE";

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    BCryptPasswordEncoder encoder;

    public Account createAccountUser(Account a) {
        a.setId_account(null);
        a.setRefreshToken(null);
        a.setRole(roleRepository.findByName(CLIENT));
        a.setActive(true);
        a.setPassword(encoder.encode(a.getPassword()));
        return accountRepository.save(a);
    }

    public Account createAccountUserAgence(Account a) {
        a.setId_account(null);
        a.setRefreshToken(null);
        a.setRole(roleRepository.findByName(AGENCE));
        a.setActive(true);
        a.setPassword(encoder.encode(a.getPassword()));
        return accountRepository.save(a);
    }

    public Account createAccountAdmin(Account a) {
        a.setId_account(null);
        a.setRefreshToken(null);
        a.setRole(roleRepository.findByName(ADMIN));
        a.setActive(true);
        a.setPassword(encoder.encode(a.getPassword()));
        return accountRepository.save(a);
    }

    public Account findByEmailAndActive(String email, boolean active){
        return accountRepository.findByEmailAndActive(email, active);
    }

}
