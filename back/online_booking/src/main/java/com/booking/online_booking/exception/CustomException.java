package com.booking.online_booking.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class CustomException extends RuntimeException {

    private final @Getter String message;
    private final @Getter HttpStatus httpStatus;
    

    @Override
    public String getMessage() {
        return this.message;
    }
    
}
