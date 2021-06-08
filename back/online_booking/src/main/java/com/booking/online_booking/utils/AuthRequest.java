package com.booking.online_booking.utils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


import lombok.Data;

@Data
public class AuthRequest {
    
    @Email(message = "entrer un email valid")
    @NotEmpty(message = "email ne doit pas étre vide")
    private String email;

    @NotEmpty
    @Pattern(message = "password must be 8 char long and contain at least 1 uppercase, 1 lowercase, 1 digit", 
             regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")
    private String password;
}
