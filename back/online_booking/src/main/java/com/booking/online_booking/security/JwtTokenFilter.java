package com.booking.online_booking.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.booking.online_booking.exception.CustomException;
import com.booking.online_booking.exception.ExceptionResponse;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtTokenFilter extends OncePerRequestFilter {


    @Autowired
    JwtTokenProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = jwtProvider.resolveToken(request);
        try {
            if (token != null && jwtProvider.validateToken(token)) {
                Authentication auth = jwtProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (CustomException e) {
            Gson mapper = new Gson();
            ExceptionResponse resp = new ExceptionResponse(List.of(e.getMessage()), e.getHttpStatus().value());
            response.setStatus(resp.getCode());
            response.setContentType("application/json");
            PrintWriter p = response.getWriter();
            p.write(mapper.toJson(resp));
            p.flush();
            return;
        }
        
        filterChain.doFilter(request, response);
    }
    
}
