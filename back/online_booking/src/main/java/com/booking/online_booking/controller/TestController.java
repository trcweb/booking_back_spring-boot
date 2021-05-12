package com.booking.online_booking.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.HotelOffer;
import com.amadeus.resources.Location;
import com.booking.online_booking.model.Account;
import com.booking.online_booking.model.DetailTypologie;
import com.booking.online_booking.model.Paiement;
import com.booking.online_booking.repository.AccountRepository;
import com.booking.online_booking.security.JwtTokenProvider;
import com.booking.online_booking.service.AmadeusService;
import com.booking.online_booking.service.DetailTypologieService;
import com.booking.online_booking.service.HotelSearchService;
import com.booking.online_booking.utils.AuthRequest;
import com.booking.online_booking.utils.Dictionarie;
import com.booking.online_booking.utils.HotelBookingRequest;
import com.booking.online_booking.utils.HotelSearchResponse;
import com.booking.online_booking.utils.NextPage;
import com.booking.online_booking.utils.HotelBookingRequest.Card;
import com.booking.online_booking.utils.HotelBookingRequest.Contact;
import com.booking.online_booking.utils.HotelBookingRequest.Guest;
import com.booking.online_booking.utils.HotelBookingRequest.Name;
import com.booking.online_booking.utils.HotelBookingRequest.Payment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
public class TestController {


    @Autowired
    private AmadeusService amadeusService;
    @Autowired
    private DetailTypologieService detailTypologieService;
    @Autowired
    HotelSearchService hotelSearchService;

    @Autowired
    AccountRepository acc;

    @Autowired
    JwtTokenProvider jwtTokenProvider;


    //@PreAuthorize("hasRole('CLIENT') or hasRole('ADMIN')")
    @GetMapping("/airport-cities-search/{st}/{sub}")
    public List<Location> airportAndCitySearch(@PathVariable("st") String searchTerm, @PathVariable("sub") String subType) throws ResponseException {
        return amadeusService.airportAndCitySearch(searchTerm, subType);
    }

    @GetMapping("/test1")
    public List<HotelOffer> hotelSearch() throws ResponseException {
        return amadeusService.hotelSearch("LON", "2021-05-18", "2021-05-20", 3, 2, null, null, null);
    }

    @PostMapping("/test2")
    public JsonObject test2(@RequestBody Map<String, String> search) throws ResponseException {
        return amadeusService.flightOffersSearch(search);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/test3/{o}")
    public HotelOffer test2(@PathVariable("o") String offer) throws ResponseException {
        HotelOffer h = amadeusService.hotelOfferAvailibility(offer);
        
        return h;
    }

    @GetMapping("/test5")
    public String test5(){
        System.out.println("...." + acc.findByEmailAndActive("test1@test", true)); 
        return "ok";
    }

    @GetMapping("/test6")
    public HotelBookingRequest test6(@RequestBody @Valid HotelBookingRequest r){
        return r;
    }

    @GetMapping("/test7")
    public JsonObject test7(){
       HotelBookingRequest b = new HotelBookingRequest();
       b.setOfferId("offerId1");
       Name n = b.new Name();
       n.setTitle("test");
       n.setFirstName("firstName");
       n.setLastName("lastName");
       Contact c = b.new Contact();
       c.setPhone("phone");
       c.setEmail("email");
       Card r = b.new Card();
       r.setVendorCode("vendorCode");
       r.setCardNumber("cardNumber");
       r.setExpiryDate("expiryDate");
       Payment p = b.new Payment();
       p.setCard(r);
       p.setMethod("method");
       Guest g = b.new Guest();
       g.setContact(c);
       g.setName(n);
       Guest[] gs = {g};
       Payment[] ps = {p};
       b.setGuests(gs);
       b.setPayments(ps);
       Gson gss = new GsonBuilder().create();
       String con = gss.toJson(b);
       JsonObject objectFromString = JsonParser.parseString(con).getAsJsonObject();
       JsonObject js = new JsonObject();
       js.add("data", objectFromString);
    
       return js;
    }


}
