package com.booking.online_booking.utils;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
public class HotelBookingRequest {
    
    @Expose
    @NotNull
    @NotEmpty
    @Pattern(message = "non valid offerId format", regexp = "^[A-Z0-9]*$")
    private String offerId;
    @Expose
    @Valid
    private Guest[] guests;
    @Expose
    @Valid
    private Payment[] payments;


    @Data
    public class Name {
        @Expose
        @NotNull
        @NotEmpty
        private String title;
        @Expose
        @NotNull
        @NotEmpty
        private String firstName;
        @Expose
        @NotNull
        @NotEmpty
        private String lastName;    
    }

    @Data
    public class Contact {
        @Expose
        @NotNull
        @NotEmpty
        @Pattern(message = "provid a valid phone nummber, exp: +33679278416", regexp = "^[+][1-9][0-9]{4,18}$")
        private String phone;
        @Expose
        @NotNull
        @NotEmpty
        @Email
        private String email;
    }

    @Data
    public class Card {
        @Expose
        @NotNull
        @NotEmpty
        @Pattern(message = "vendorCode should be to characters exectly, exp: VI (Visa)", regexp = "^[A-Z]{2}$")
        private String vendorCode;
        @Expose
        @NotNull
        @NotEmpty
        @Pattern(message = "cardNumber format error", regexp = "^[0-9]*$")
        private String cardNumber;
        @Expose
        @NotNull
        @NotEmpty
        @Pattern(message = "expiryDate format error", regexp = "^[0-9]{4}-[0-9]{2}$")
        private String expiryDate;
    }

    @Data
    public class Guest {
        @Expose
        @NotNull
        @Valid
        private Name name;
        @Expose
        @NotNull
        @Valid
        private Contact contact;
    }

    @Data
    public class Payment {
        @Expose
        @NotNull
        @NotEmpty
        private String method;
        @Expose
        @NotNull
        @Valid
        private Card card;
    }

}

