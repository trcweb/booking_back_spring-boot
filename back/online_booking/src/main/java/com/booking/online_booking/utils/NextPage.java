package com.booking.online_booking.utils;

import com.amadeus.resources.HotelOffer;
import com.google.gson.annotations.Expose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NextPage {

    @Expose
    private String amadeusNext;
    @Expose
    private int localNext;
    @Expose
    private boolean amadeusSearchable;
    @Expose
    private boolean localSearchable;

    public String getAmadeusNextParam(){
        String pageNumber = null;
        if (amadeusNext != null && !amadeusNext.isEmpty()) {
            String[] parts = amadeusNext.split("=");
            if (parts.length > 1) {
                pageNumber = parts[parts.length - 1];
            }                        
        }        
        return pageNumber;
    }

    public void setAmadeusNext(HotelOffer h){
        this.amadeusNext = h.getResponse().getResult().get("meta").getAsJsonObject()
                                                      .get("links").getAsJsonObject()
                                                      .get("next").getAsString();
    }

}
