package com.booking.online_booking.utils;

import java.util.ArrayList;
import java.util.List;

import com.amadeus.resources.Location;
import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
public class LocationResponse {
    
    @Expose
    private String type;
    @Expose
    private String subType;
    @Expose
    private String name;
    @Expose
    private String detailedName;
    @Expose
    private String iataCode;
    @Expose
    private Address address;

    @Data
    public class Address {
        @Expose
        private String cityName;
        @Expose
        private String countryName;
    }

    public static List<LocationResponse> extractLoaction(List<Location> locations) {
        List<LocationResponse> lr = new ArrayList<>();
        for (Location location : locations) {
            LocationResponse l = new LocationResponse();
            Address a = l.new Address();
            a.setCityName(location.getAddress().getCityName());
            a.setCountryName(location.getAddress().getCountryName());
            l.setAddress(a);
            l.setType(location.getType());
            l.setSubType(location.getSubType());
            l.setName(location.getName());
            l.setDetailedName(location.getDetailedName());
            l.setIataCode(location.getIataCode());
            lr.add(l);
        }
        return lr;
    }
    
}
