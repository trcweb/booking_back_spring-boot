package com.booking.online_booking.security;

import java.io.PrintWriter;
import java.util.List;

import com.booking.online_booking.exception.ExceptionResponse;
import com.booking.online_booking.service.UserDetailsServiceImpl;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // enable cors and disable csrf
        http.cors().and().csrf().disable();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests()
            .antMatchers("/auth/signin").permitAll()
            .antMatchers("/auth/refresh-token/**").permitAll()
            .antMatchers("/test/**").permitAll()
            .antMatchers("/hotels/airport-cities-search/**").permitAll()
            .antMatchers("/hotels/searchOffers/**").permitAll()
            .antMatchers("/hotels/hotelOfferSearch/**").permitAll()
            .antMatchers("/hotels/hotelOfferAvailibility/**").permitAll()
            .antMatchers("/hotels/hotel-booking").permitAll()
            .antMatchers("/account/createAccount").permitAll()
            .antMatchers("/flights/**").permitAll()
            .anyRequest().authenticated();
        
        http
        .exceptionHandling()
        .authenticationEntryPoint(
                (request, response, ex) -> {
                    Gson mapper = new Gson();
                    ExceptionResponse resp = new ExceptionResponse(List.of(ex.getMessage()), HttpStatus.UNAUTHORIZED.value());
                    response.setStatus(resp.getCode());
                    response.setContentType("application/json");
                    PrintWriter p = response.getWriter();
                    p.write(mapper.toJson(resp));
                    p.flush();
                    return;
                }
        );

        http.addFilterBefore(tokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public JwtTokenFilter tokenFilterBean(){
        return new JwtTokenFilter();
    }

    @Bean
    public GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults(""); // Remove the ROLE_ prefix
    }
    
    
}
