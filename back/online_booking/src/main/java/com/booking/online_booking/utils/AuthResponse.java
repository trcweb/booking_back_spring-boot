package com.booking.online_booking.utils;

import com.booking.online_booking.model.User;
import com.booking.online_booking.model.UserAgence;
import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
public class AuthResponse {
    @Expose
    private String token;
    @Expose
    private String refreshToken;
    @Expose
    private UserAgence userAgence;
    @Expose
    private User user;
    @Expose
    private String role;
}
