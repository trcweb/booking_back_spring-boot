package com.booking.online_booking.utils;

import com.booking.online_booking.model.User;
import com.booking.online_booking.model.UserAgence;

import lombok.Data;

@Data
public class AuthResponse {
    private String token;
    private String refreshToken;
    private UserAgence userAgence;
    private User user;
    private String role;
}
