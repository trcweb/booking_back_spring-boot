package com.booking.online_booking.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NextPage {

    private String amadeusNext;
    private int localNext;
    private boolean amadeusSearchable;
    private boolean localSearchable;

    public String getAmadeusNextParam(){
        String pageNumber = null;
        if (amadeusNext != null) {
            String[] parts = amadeusNext.split("=");
            if (parts.length > 1) {
                pageNumber = parts[parts.length - 1];
            }                        
        }        
        return pageNumber;
    }

}
