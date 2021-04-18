package com.booking.online_booking.utils;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HotelSearchResponse {
    
    private List<HotelOfferResponse> hotelOffers;
    private NextPage nextPage;
    private Dictionarie dictionarie;

}
