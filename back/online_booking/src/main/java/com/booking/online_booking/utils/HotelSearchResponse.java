package com.booking.online_booking.utils;

import java.util.List;

import com.booking.online_booking.model.Commission;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelSearchResponse {
    private List<HotelOfferResponse> hotelOffers;
    private NextPage nextPage;
    private Dictionarie dictionarie;
    private Commission commission;

}
