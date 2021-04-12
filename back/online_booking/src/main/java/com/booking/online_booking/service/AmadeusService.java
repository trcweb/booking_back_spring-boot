package com.booking.online_booking.service;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.HotelOffer;
import com.amadeus.resources.Location;
import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AmadeusService {

    private boolean isInitialized = false;
    private Amadeus amadeusClient = null;

    @Value("${amadeus.client.id}")
    private String API_KEY;

    @Value("${amadeus.client.secret}")
    private String API_SECRET;



    private void initializeClient() {
        try {
            amadeusClient = Amadeus.builder(API_KEY, API_SECRET)
                                   .build();
            isInitialized = true;
            System.out.println("initialized successfully!!");
        } catch (Exception e) {
            System.out.println("exp: " + e.getMessage());
        }                    
    }

    // initialization of amadeus client
    @PostConstruct
    public void initialize() {
        if (!isInitialized) {
            initializeClient();
        }
    }

    // returns a list of location based on searchTerm and a subType creteria
    public JsonObject airportAndCitySearch(String searchTerm, String subType) throws ResponseException {
        Location[] locations = null;
        JsonObject jbs = null;
        if (!isInitialized) {
            initializeClient();
        }

        locations = amadeusClient.referenceData.locations.get(Params.with("keyword", searchTerm)
                                                                    .and("subType", subType));
 
        if (locations.length > 0) {
            jbs = locations[0].getResponse().getResult();
        }
        
        return jbs;
    }

    // search for hotel offers
    public List<HotelOffer> hotelSearch(String cityCode,
                                    String checkInDate,
                                    String checkOutDate,
                                    int adults,
                                    int roomQuantity,
                                    List<Integer> ratings,
                                    String priceRange,
                                    String nextPage
                                    ) throws ResponseException {
        if (!isInitialized) {
            initializeClient();
        }

        Params params = Params.with("cityCode", cityCode)
                              .and("checkInDate", checkInDate)
                              .and("checkOutDate", checkOutDate)
                              .and("adults", adults)
                              .and("roomQuantity", roomQuantity)
                              .and("currency", "EUR")
                              .and("includeClosed", "false")
                              .and("paymentPolicy", "NONE")
                              .and("includeClosed", "false")
                              .and("bestRateOnly", "true")
                              .and("view", "FULL")
                              .and("sort", "PRICE");
       
        if (ratings.size() > 0) {
            String r = ratings.stream().map(rate -> rate.toString()).collect(Collectors.joining(","));
            params = params.and("ratings", r);
        }
        if (priceRange != null) {
            params = params.and("priceRange", priceRange);
        }
        if (nextPage != null) {
            params = params.and("page[offset]", nextPage);
        }

        List<HotelOffer> offers = Arrays.asList(amadeusClient.shopping.hotelOffers.get(params));
        offers.addAll(Arrays.asList((HotelOffer[]) amadeusClient.next(offers.get(0))));
        return offers;
                                                                
    }

    public HotelOffer[] next(HotelOffer[] res) throws ResponseException{

        HotelOffer[] offers = (HotelOffer[]) amadeusClient.next(res[0]);
        return offers;
    }
 
    public JsonObject flightOffersSearch(Map<String, String> mapParams) throws ResponseException {
        if (!isInitialized) {
            initializeClient();
        }

        Params params = null;
        JsonObject result = null;

        for (Map.Entry<String, String> entry : mapParams.entrySet()) {

            if (params == null) {
                params = Params.with(entry.getKey(), entry.getValue());
            } else {
                params = params.and(entry.getKey(), entry.getValue());
            }
        }
        
        FlightOfferSearch[] flightOffersSearches = amadeusClient.shopping.flightOffersSearch.get(params);

        if (flightOffersSearches.length > 0) {
            result = flightOffersSearches[0].getResponse().getResult();
        }
        
        return result;

    }

   
}
