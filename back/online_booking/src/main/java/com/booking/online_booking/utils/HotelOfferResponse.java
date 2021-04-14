package com.booking.online_booking.utils;

import java.util.List;

import com.amadeus.resources.HotelOffer;
import com.booking.online_booking.model.Hotel;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HotelOfferResponse {
    private Hotel hotel;
    private List<OfferResponse> offers;
    private List<String> amenities;
    private String source;

    public static List<HotelOfferResponse> extractHotelOfferResponses(List<HotelOffer> hotelOffers){

        return null;
    }
}
