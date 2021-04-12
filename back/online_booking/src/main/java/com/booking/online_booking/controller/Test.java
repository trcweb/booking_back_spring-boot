package com.booking.online_booking.controller;

import java.util.List;
import java.util.Map;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.HotelOffer;
import com.booking.online_booking.model.DetailTypologie;
import com.booking.online_booking.service.AmadeusService;
import com.booking.online_booking.service.DetailTypologieService;
import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/test")
public class Test {


    @Autowired
    private AmadeusService amadeusService;
    @Autowired
    private DetailTypologieService detailTypologieService;

    


    @GetMapping("/airport-cities-search/{st}/{sub}")
    public JsonObject airportAndCitySearch(@PathVariable("st") String searchTerm, @PathVariable("sub") String subType) throws ResponseException {
        return amadeusService.airportAndCitySearch(searchTerm, subType);
    }

    @GetMapping("/hotel/{cityCode}/{checkInDate}/{checkOutDate}/{adults}/{roomQuantity}")
    public List<HotelOffer> hotelSearch(
    @PathVariable("cityCode") String cityCode,
    @PathVariable("checkInDate") String checkInDate,
    @PathVariable("checkOutDate") String checkOutDate,
    @PathVariable("adults") Integer adults,
    @PathVariable("roomQuantity") Integer roomQuantity) throws ResponseException {
        return amadeusService.hotelSearch(cityCode, checkInDate, checkOutDate, adults, roomQuantity, null, null, null);
    }

    @PostMapping("/test2")
    public JsonObject test2(@RequestBody Map<String, String> search) throws ResponseException {
        return amadeusService.flightOffersSearch(search);
    }

    // @GetMapping("/test3")
    // public List<DetailTypologie> test3() {
    //     List<DetailTypologie> dt = detailTypologieService.searchByCityAndDateAndNbr(5, "2021-05-16", "MUC").getContent();
    //     return dt;
    // }
}
