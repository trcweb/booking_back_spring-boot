package com.booking.online_booking.utils;

import java.util.List;

import com.amadeus.resources.HotelOffer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HotelSearchResponse {
    
    private List<HotelOfferResponse> hotelOffers;
    private NextPage nextPage;
    private Dictionarie dictionarie;

    public static HotelSearchResponse extracResponse(List<HotelOffer> hotelOffers){

        return null;
    }
}
