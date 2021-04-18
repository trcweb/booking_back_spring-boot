package com.booking.online_booking.service;

import java.util.List;
import java.util.stream.Collectors;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.HotelOffer;
import com.booking.online_booking.model.DetailTypologie;
import com.booking.online_booking.utils.Dictionarie;
import com.booking.online_booking.utils.HotelOfferResponse;
import com.booking.online_booking.utils.HotelSearchResponse;
import com.booking.online_booking.utils.NextPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class HotelSearchService {
    
    @Autowired
    AmadeusService amadeusService;
    @Autowired
    DetailTypologieService detailTypologieService;


    public HotelSearchResponse searchOffers(String cityCode,
                            String checkInDate,
                            String checkOutDate,
                            List<Integer> rooms,
                            List<Integer> ratings,
                            int[] priceRange,
                            NextPage next) throws ResponseException{
        List<HotelOffer> amadeusOffers = null;
        // Slice<DetailTypologie> localOffers = null;
        // List<DetailTypologie> filtredOffers = null;
        NextPage responseNextPage = new NextPage(null, 0, false, false);
        HotelSearchResponse hotelSearchResponse = new HotelSearchResponse(null, null, null);

        int roomQuantity = rooms.size();
        int adults = rooms.stream().collect(Collectors.summingInt(Integer::intValue));
                            
        
        // search if there is any available data 
        if (next.isAmadeusSearchable()) {
            String range = null;
            if (priceRange != null && priceRange.length > 0) {
                range = priceRange[0] + "-" + priceRange[1];
            }
            amadeusOffers = amadeusService.hotelSearch(cityCode, 
                                                        checkInDate, 
                                                        checkOutDate, 
                                                        adults, 
                                                        roomQuantity, 
                                                        ratings, 
                                                        range,
                                                        next.getAmadeusNextParam());
            if (!amadeusOffers.isEmpty()) {
                try {
                    responseNextPage.setAmadeusNext(amadeusOffers.get(amadeusOffers.size() - 1));
                    responseNextPage.setAmadeusSearchable(true);
                    
                } catch (Exception e) {
                    System.out.println("exceptions while creating next link from amadeus response");
                }
            }           
        }
        // search if there is any available data 
        // if (next.isLocalSearchable()) {
        //     localOffers = detailTypologieService.searchByCityAndDateAndNbr(adults, checkInDate, cityCode, next.getLocalNext());
        //     responseNextPage.setLocalSearchable(localOffers.hasNext());
        //     responseNextPage.setLocalNext(next.getLocalNext() + 1);
        //     filtredOffers = localOffers.getContent();
        //     // if there is a price filter and the list of offers != null
        //     if (!localOffers.isEmpty()) {
        //         if (priceRange.length > 0 ) {
        //             filtredOffers = filtredOffers.stream()
        //                                         .filter(dt -> dt.filterByPriceRange(priceRange[0], priceRange[1]))
        //                                         .collect(Collectors.toList());
        //         }
        //         if (!ratings.isEmpty()) {
        //             filtredOffers = filtredOffers.stream()
        //                                         .filter(dt -> dt.getDetailHotel().getHotel().filterByStars(ratings))
        //                                         .collect(Collectors.toList());
        //         }
        //     }
        // }

        if (amadeusOffers != null && !amadeusOffers.isEmpty()) {
            hotelSearchResponse.setHotelOffers(HotelOfferResponse.extractHotelOfferResponses(amadeusOffers));
            hotelSearchResponse.setNextPage(responseNextPage);
            hotelSearchResponse.setDictionarie(Dictionarie.extractdiDictionarie(amadeusOffers.get(amadeusOffers.size() - 1)));
        }
        
        return hotelSearchResponse;
    }
}
