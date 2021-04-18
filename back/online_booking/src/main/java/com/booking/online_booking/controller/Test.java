package com.booking.online_booking.controller;

import java.util.List;
import java.util.Map;

import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.HotelOffer;
import com.amadeus.resources.Location;
import com.booking.online_booking.model.DetailTypologie;
import com.booking.online_booking.service.AmadeusService;
import com.booking.online_booking.service.DetailTypologieService;
import com.booking.online_booking.service.HotelSearchService;
import com.booking.online_booking.utils.Dictionarie;
import com.booking.online_booking.utils.HotelSearchResponse;
import com.booking.online_booking.utils.NextPage;
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
    @Autowired
    HotelSearchService hotelSearchService;



    @GetMapping("/airport-cities-search/{st}/{sub}")
    public List<Location> airportAndCitySearch(@PathVariable("st") String searchTerm, @PathVariable("sub") String subType) throws ResponseException {
        return amadeusService.airportAndCitySearch(searchTerm, subType);
    }

    @GetMapping("/test1")
    public List<HotelOffer> hotelSearch() throws ResponseException {
        return amadeusService.hotelSearch("LON", "2021-04-18", "2021-04-20", 3, 2, null, null, null);
    }

    @PostMapping("/test2")
    public JsonObject test2(@RequestBody Map<String, String> search) throws ResponseException {
        return amadeusService.flightOffersSearch(search);
    }

    @GetMapping("/test3")
    public HotelSearchResponse test2() throws ResponseException {
        HotelSearchResponse h = hotelSearchService.searchOffers("LON", 
                                                    "2021-04-18", 
                                                    "2021-04-20", 
                                                    List.of(2,1), 
                                                    null, 
                                                    null, 
                                                    new NextPage("", 0, true, false));
        
        return h;
    }

}
