package com.booking.online_booking.utils;

import java.util.List;

import com.booking.online_booking.model.Commission;
import com.google.gson.annotations.Expose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelSearchResponse {
    @Expose
    private List<HotelOfferResponse> hotelOffers;
    @Expose
    private NextPage nextPage;
    @Expose
    private Dictionarie dictionarie;
    @Expose
    private Commission commission;

}
