package com.booking.online_booking.utils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


import lombok.Data;

@Data
public class AuthRequest {
    
    @Email(message = "entrer un email valid")
    @NotEmpty(message = "email ne doit pas étre vide")
    private String email;

    @NotEmpty
    private String password;
}
