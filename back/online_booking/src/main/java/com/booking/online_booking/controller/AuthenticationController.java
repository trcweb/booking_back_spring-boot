package com.booking.online_booking.controller;

import javax.validation.Valid;

import com.booking.online_booking.exception.CustomException;
import com.booking.online_booking.model.Account;
import com.booking.online_booking.model.User;
import com.booking.online_booking.model.UserAgence;
import com.booking.online_booking.repository.AccountRepository;
import com.booking.online_booking.repository.UserAgenceRepository;
import com.booking.online_booking.repository.UserRepository;
import com.booking.online_booking.security.JwtTokenProvider;
import com.booking.online_booking.service.RefreshTokenService;
import com.booking.online_booking.service.UserDetailsServiceImpl;
import com.booking.online_booking.utils.AuthRequest;
import com.booking.online_booking.utils.AuthResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthenticationController {
    

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private RefreshTokenService refreshTokenService;

    @Autowired
    private UserAgenceRepository userAgenceRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/signin")
    public AuthResponse signin(@RequestBody @Valid AuthRequest auth){
        AuthResponse authResponse = new AuthResponse();
        String token = userDetailsService.signin(auth.getEmail(), auth.getPassword());
        String username = jwtTokenProvider.getUsername(token);
        Account a = accountRepository.findByEmailAndActive(username, true);
        String refreshToken = refreshTokenService.creatRefreshToken();
        refreshTokenService.setRefreshToken(a.getId_account(), refreshToken);

        if (a.getRole().getName().equals("AGENCE")) {
            UserAgence ua = userAgenceRepository.findByAccountEmail(username);
            ua.getAccount().setPassword(null);
            authResponse.setUserAgence(ua);
        } else {
            User usr = userRepository.findByAccountEmail(username);
            usr.getAccount().setPassword(null);
            authResponse.setUser(usr);
        }

        authResponse.setToken(token);
        authResponse.setRefreshToken(refreshToken);
        authResponse.setRole(a.getRole().getName());
        return authResponse;
    }

    @GetMapping("/signout")
    public String signout(Authentication auth){
        refreshTokenService.unvalidateRefreshToken(auth.getName());
        return "signout successfull";
    }

    @GetMapping("/refresh-token/{refreshToken}")
    public AuthResponse refreshToken(@PathVariable("refreshToken") String refreshToken) throws CustomException{
        Account a = accountRepository.findByRefreshToken(refreshToken);
        if (a == null) {
            throw new CustomException("no account found with provided refresh token", HttpStatus.NOT_FOUND );
        }
        AuthResponse response = new AuthResponse();
        String token = jwtTokenProvider.generateAccessToken(a.getEmail());
        String newRefreshToken = refreshTokenService.creatRefreshToken();
        refreshTokenService.setRefreshToken(a.getId_account(), newRefreshToken);
        if (a.getRole().getName().equals("AGENCE")) {
            UserAgence ua = userAgenceRepository.findByAccountEmail(a.getEmail());
            ua.getAccount().setPassword(null);
            response.setUserAgence(ua);
        } else {
            User usr = userRepository.findByAccountEmail(a.getEmail());
            usr.getAccount().setPassword(null);
            response.setUser(usr);
        }
        response.setToken(token);
        response.setRefreshToken(newRefreshToken);
        response.setRole(a.getRole().getName());
        return response;
    }    

}
