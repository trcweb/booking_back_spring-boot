package com.booking.online_booking.utils;

import java.util.ArrayList;
import java.util.List;

import com.amadeus.resources.HotelOffer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelOfferResponse {
    private HotelResponse hotel;
    private List<OfferResponse> offers;
    private String source;

    public static List<HotelOfferResponse> extractHotelOfferResponses(List<HotelOffer> hotelOffers){
        List<HotelOfferResponse> ho = new ArrayList<>();
        for (HotelOffer hotelOffer : hotelOffers) {
            HotelOfferResponse h = new HotelOfferResponse();
            h.setHotel(HotelResponse.extracHotelResponse(hotelOffer.getHotel()));
            h.setOffers(OfferResponse.extractOffers(hotelOffer.getOffers()));
            h.setSource("amadeus");
            ho.add(h);
        }
        return ho;
    }

    public static HotelOfferResponse extractHotelOfferResponses(HotelOffer hotelOffer){
       
        HotelOfferResponse h = new HotelOfferResponse();
        h.setHotel(HotelResponse.extracHotelResponse(hotelOffer.getHotel()));
        h.setOffers(OfferResponse.extractOffers(hotelOffer.getOffers()));
        h.setSource("amadeus");
        return h;
    }

    
}
