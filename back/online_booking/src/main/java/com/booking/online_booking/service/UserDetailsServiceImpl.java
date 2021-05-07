package com.booking.online_booking.service;

import com.booking.online_booking.exception.CustomException;
import com.booking.online_booking.model.Account;
import com.booking.online_booking.repository.AccountRepository;
import com.booking.online_booking.security.JwtTokenProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService  {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final Account account = accountRepository.findByEmailAndActive(email, true);

        if (account == null) {
            throw new UsernameNotFoundException("User '" + email + "' not found");
        }

        return User.withUsername(email)
            .password(account.getPassword())
            .authorities(new SimpleGrantedAuthority(account.getRole().getName()))
            .accountExpired(false)
            .accountLocked(false)
            .credentialsExpired(false)
            .disabled(false)
            .build();
    }

    public String signin(String email, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            return jwtTokenProvider.generateAccessToken(email);
        } catch (AuthenticationException e) {
            throw new CustomException(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
        
    }
    
}
