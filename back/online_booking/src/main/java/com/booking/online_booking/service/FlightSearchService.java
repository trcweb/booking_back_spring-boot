package com.booking.online_booking.service;

import java.util.Map;

import com.amadeus.exceptions.ResponseException;
import com.booking.online_booking.model.Commission;
import com.booking.online_booking.repository.RoleRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class FlightSearchService {
    
    @Autowired
    AmadeusService amadeusService;

    @Autowired
    RoleRepository roleRepository;

    public JsonObject flightOffersSearch(Map<String, String> mapParams, Authentication auth) throws ResponseException {
        JsonObject flightOffers = amadeusService.flightOffersSearch(mapParams);
        Commission c = null;
        if (auth == null || auth instanceof AnonymousAuthenticationToken) {
            c = roleRepository.findByName("ANONYMOUS").getCommission();
        } else {
            c = roleRepository.findByName(auth.getAuthorities().iterator().next().getAuthority()).getCommission();
        }
        Gson gss = new GsonBuilder().create();
        String commission = gss.toJson(c);
        JsonObject commissionJSON = JsonParser.parseString(commission).getAsJsonObject();
        flightOffers.remove("meta");
        flightOffers.add("commission", commissionJSON);
        return flightOffers;
    }

    public JsonObject flightOffersPrice(JsonObject flightOffer, Authentication auth) throws ResponseException {
        JsonObject offer = amadeusService.flightOffersPrice(flightOffer);
        Commission c = null;
        if (auth == null || auth instanceof AnonymousAuthenticationToken) {
            c = roleRepository.findByName("ANONYMOUS").getCommission();
        } else {
            c = roleRepository.findByName(auth.getAuthorities().iterator().next().getAuthority()).getCommission();
        }
        Gson gss = new GsonBuilder().create();
        String commission = gss.toJson(c);
        JsonObject commissionJSON = JsonParser.parseString(commission).getAsJsonObject();
        offer.add("commission", commissionJSON);
        return offer;
    }
}
