package com.booking.online_booking.utils;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


import lombok.Data;

@Data
public class HotelBookingRequest {
    
    @NotNull
    @NotEmpty
    @Pattern(message = "non valid offerId format", regexp = "^[A-Z0-9]*$")
    private String offerId;
    @Valid
    private Guest[] guests;
    @Valid
    private Payment[] payments;


    @Data
    public class Name {
        @NotNull
        @NotEmpty
        private String title;
        @NotNull
        @NotEmpty
        private String firstName;
        @NotNull
        @NotEmpty
        private String lastName;    
    }

    @Data
    public class Contact {
        @NotNull
        @NotEmpty
        @Pattern(message = "provid a valid phone nummber, exp: +33679278416", regexp = "^[+][1-9][0-9]{4,18}$")
        private String phone;
        @NotNull
        @NotEmpty
        @Email
        private String email;
    }

    @Data
    public class Card {
        @NotNull
        @NotEmpty
        @Pattern(message = "vendorCode should be to characters exectly, exp: VI (Visa)", regexp = "^[A-Z]{2}$")
        private String vendorCode;
        @NotNull
        @NotEmpty
        @Pattern(message = "cardNumber format error", regexp = "^[0-9]*$")
        private String cardNumber;
        @NotNull
        @NotEmpty
        @Pattern(message = "expiryDate format error", regexp = "^[0-9]{4}-[0-9]{2}$")
        private String expiryDate;
    }

    @Data
    public class Guest {
        @NotNull
        @Valid
        private Name name;
        @NotNull
        @Valid
        private Contact contact;
    }

    @Data
    public class Payment {
        @NotNull
        @NotEmpty
        private String method;
        @NotNull
        @Valid
        private Card card;
    }

}

