package com.booking.online_booking.controller;

import java.util.Map;

import com.amadeus.exceptions.ResponseException;
import com.booking.online_booking.service.AmadeusService;
import com.booking.online_booking.service.FlightSearchService;
import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/flights")
public class FlightsController {
    
    @Autowired
    FlightSearchService flightSearchService;

    @PostMapping("/searchOffers")
    public JsonObject flightOffersSearch(@RequestBody Map<String, String> mapParams, Authentication auth) throws ResponseException {
        return flightSearchService.flightOffersSearch(mapParams, auth);
    }

    @PostMapping("/searchOfferPrice")
    public JsonObject flightOffersPrice(@RequestBody JsonObject flightOffer, Authentication auth) throws ResponseException {
        return flightSearchService.flightOffersPrice(flightOffer, auth);
    }
}
