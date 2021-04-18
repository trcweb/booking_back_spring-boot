package com.booking.online_booking.utils;


import com.amadeus.resources.HotelOffer;
import com.google.gson.JsonObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dictionarie {
    //target currency
    private String currency;
    // origin * this.rate = target_value
    private double rate;

    public static Dictionarie extractdiDictionarie(HotelOffer h){
        Dictionarie d = null;
        try {
            JsonObject o =  h.getResponse().getResult().getAsJsonObject("dictionaries")
                            .getAsJsonObject("currencyConversionLookupRates");
            o = o.getAsJsonObject(o.keySet().iterator().next());
            d = new Dictionarie(o.get("target").getAsString(), o.get("rate").getAsDouble());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return d;
    }
}
