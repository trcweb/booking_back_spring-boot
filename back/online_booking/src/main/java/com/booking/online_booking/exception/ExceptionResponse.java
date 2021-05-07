package com.booking.online_booking.exception;

import java.util.List;

import com.google.gson.annotations.Expose;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponse {
    @Expose
    private List<String> message;
    @Expose
    private int code;
}
