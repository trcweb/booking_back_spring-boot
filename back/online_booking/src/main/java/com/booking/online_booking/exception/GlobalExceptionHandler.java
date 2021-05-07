package com.booking.online_booking.exception;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.amadeus.exceptions.ResponseException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {
    
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponse> handleCustomException(CustomException exp) throws IOException{
        ExceptionResponse exr = new ExceptionResponse(List.of(exp.getMessage()), exp.getHttpStatus().value());
        ResponseEntity<ExceptionResponse> r = new ResponseEntity<>(exr, exp.getHttpStatus());
        return r;
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ExceptionResponse> handleAccessDinedException(HttpServletResponse res) throws IOException{
        ExceptionResponse exr = new ExceptionResponse(List.of("Access denied"), HttpStatus.FORBIDDEN.value());
        ResponseEntity<ExceptionResponse> r = new ResponseEntity<>(exr, HttpStatus.FORBIDDEN);
        return r;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleValidationException(HttpServletResponse res, MethodArgumentNotValidException exp) throws IOException{
        BindingResult result = exp.getBindingResult();
        List<String> errorList = new ArrayList<>();
        result.getFieldErrors().forEach((fieldError) -> errorList.add(
                                                                        fieldError.getObjectName()
                                                                        +"."+
                                                                        fieldError.getField()
                                                                        +" : " +
                                                                        fieldError.getDefaultMessage() ));
        ExceptionResponse exr = new ExceptionResponse(errorList, HttpStatus.UNPROCESSABLE_ENTITY.value());
        ResponseEntity<ExceptionResponse> r = new ResponseEntity<>(exr, HttpStatus.UNPROCESSABLE_ENTITY);
        return r;
    }

    @ExceptionHandler(ResponseException.class)
    public ResponseEntity<ExceptionResponse> handleResponseException(HttpServletResponse res, ResponseException exp) throws IOException{
        ExceptionResponse exr = new ExceptionResponse(List.of(exp.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR.value());
        ResponseEntity<ExceptionResponse> r = new ResponseEntity<>(exr, HttpStatus.INTERNAL_SERVER_ERROR);
        return r;
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ExceptionResponse> handleMethodNotSupportedException(HttpServletResponse res, HttpRequestMethodNotSupportedException exp) throws IOException{
        ExceptionResponse exr = new ExceptionResponse(List.of(exp.getMessage()), HttpStatus.METHOD_NOT_ALLOWED.value());
        ResponseEntity<ExceptionResponse> r = new ResponseEntity<>(exr, HttpStatus.METHOD_NOT_ALLOWED);
        return r;
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(HttpServletResponse res, Exception exp) throws IOException{
        ExceptionResponse exr = new ExceptionResponse(List.of(exp.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR.value());
        ResponseEntity<ExceptionResponse> r = new ResponseEntity<>(exr, HttpStatus.INTERNAL_SERVER_ERROR);
        return r;
    }
}
