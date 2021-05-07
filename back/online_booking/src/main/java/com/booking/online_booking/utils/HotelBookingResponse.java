package com.booking.online_booking.utils;

import com.amadeus.resources.HotelBooking;
import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
public class HotelBookingResponse {
    @Expose
    private String type;
    @Expose
    private String id;
    @Expose
    private String providerConfirmationId;
    @Expose
    private AssociatedRecord associatedRecords;

    @Data
    public class AssociatedRecord {
        @Expose
        private String reference;
        @Expose
        private String originSystemCode;
    }

    public static HotelBookingResponse extractBookingResponse(HotelBooking booking) {
        HotelBookingResponse r = new HotelBookingResponse();
        AssociatedRecord a = r.new AssociatedRecord();
        a.setOriginSystemCode(booking.getAssociatedRecords()[0].getOriginSystemCode());
        a.setReference(booking.getAssociatedRecords()[0].getReference());
        r.setAssociatedRecords(a);
        r.setType(booking.getType());
        r.setId(booking.getId());
        r.setProviderConfirmationId(booking.getProviderConfirmationId());
        return r;
    }
}
