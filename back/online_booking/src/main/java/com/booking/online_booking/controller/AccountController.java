package com.booking.online_booking.controller;

import javax.validation.Valid;

import com.booking.online_booking.exception.CustomException;
import com.booking.online_booking.model.Account;
import com.booking.online_booking.model.User;
import com.booking.online_booking.model.UserAgence;
import com.booking.online_booking.service.AccountService;
import com.booking.online_booking.service.RefreshTokenService;
import com.booking.online_booking.service.UserAgenceService;
import com.booking.online_booking.service.UserDetailsServiceImpl;
import com.booking.online_booking.service.UserService;
import com.booking.online_booking.utils.AuthResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    UserAgenceService userAgenceService;

    @Autowired
    UserService userService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private RefreshTokenService refreshTokenService;

    @PostMapping("/createAccount")
    public AuthResponse createAccount(@RequestBody @Valid User u) {
        User us = userService.findById(u);
        Account ac = accountService.findByEmailAndActive(u.getAccount().getEmail(), true);
        if(us != null) {
            throw new CustomException("this CIN is already used", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if(ac != null) {
            throw new CustomException("this email is already used", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        String password = u.getAccount().getPassword();
        Account a = accountService.createAccountUser(u.getAccount());
        u.setAccount(a);
        u = userService.createUser(u);

        String token = userDetailsService.signin(a.getEmail(), password);
        String refreshToken = refreshTokenService.creatRefreshToken();
        refreshTokenService.setRefreshToken(a.getId_account(), refreshToken);

        u.getAccount().setPassword(null);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setUser(u);
        authResponse.setToken(token);
        authResponse.setRefreshToken(refreshToken);
        authResponse.setRole(a.getRole().getName());
        return authResponse;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/createAccountAgence")
    public UserAgence createAccountAgence(@RequestBody @Valid UserAgence u) {
        UserAgence us = userAgenceService.findByMatricule(u);
        Account ac = accountService.findByEmailAndActive(u.getAccount().getEmail(), true);
        if(us != null) {
            throw new CustomException("ce matricule est déja utilisé", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if(ac != null) {
            throw new CustomException("this email is already used", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        Account a = accountService.createAccountUserAgence(u.getAccount());
        u.setAccount(a);
        u = userAgenceService.createUserAgence(u);
        u.getAccount().setPassword(null);
        return u;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/createAccountAdmin")
    public User createAccountAdmin(@RequestBody @Valid User u) {
        User us = userService.findById(u);
        Account ac = accountService.findByEmailAndActive(u.getAccount().getEmail(), true);
        if(us != null) {
            throw new CustomException("this CIN is already used", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if(ac != null) {
            throw new CustomException("this email is already used", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        Account a = accountService.createAccountAdmin(u.getAccount());
        u.setAccount(a);
        u = userService.createUser(u);
        u.getAccount().setPassword(null);
        return u;
    }
}
