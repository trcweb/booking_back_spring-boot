package com.booking.online_booking.controller;

import java.util.List;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Location;
import com.booking.online_booking.service.AmadeusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/hotels")
public class Hotels {
    
    @Autowired
    AmadeusService amadeusService;

    @GetMapping("/airport-cities-search/{st}/{sub}")
    public List<Location> airportAndCitySearch(@PathVariable("st") String searchTerm, @PathVariable("sub") String subType) throws ResponseException {
        return amadeusService.airportAndCitySearch(searchTerm, subType);
    }
}
