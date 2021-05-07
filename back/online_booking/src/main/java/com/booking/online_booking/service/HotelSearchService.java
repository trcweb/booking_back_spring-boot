package com.booking.online_booking.service;

import java.util.List;
import java.util.stream.Collectors;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.HotelBooking;
import com.amadeus.resources.HotelOffer;
import com.amadeus.resources.Location;
import com.booking.online_booking.repository.RoleRepository;
import com.booking.online_booking.utils.Dictionarie;
import com.booking.online_booking.utils.HotelBookingRequest;
import com.booking.online_booking.utils.HotelOfferResponse;
import com.booking.online_booking.utils.HotelSearchResponse;
import com.booking.online_booking.utils.NextPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class HotelSearchService {
    
    @Autowired
    AmadeusService amadeusService;
    @Autowired
    DetailTypologieService detailTypologieService;
    @Autowired
    RoleRepository roleRepository;

   
   public List<Location> airportAndCitySearch(String searchTerm, String subType) throws ResponseException {
    return amadeusService.airportAndCitySearch(searchTerm, subType);
   }

    /**
     * searches hotel offers for given search params
     * 
     * @param cityCode
     * @param checkInDate
     * @param checkOutDate
     * @param rooms
     * @param ratings
     * @param priceRange
     * @param next
     * @return HotelSearchResponse
     * @throws ResponseException
     */
    public HotelSearchResponse searchOffers(String cityCode,
                            String checkInDate,
                            String checkOutDate,
                            List<Integer> rooms,
                            List<Integer> ratings,
                            int[] priceRange,
                            NextPage next,
                            Authentication auth) throws ResponseException{
        List<HotelOffer> amadeusOffers = null;
        // Slice<DetailTypologie> localOffers = null;
        // List<DetailTypologie> filtredOffers = null;
        NextPage responseNextPage = new NextPage(null, 0, false, false);
        HotelSearchResponse hotelSearchResponse = new HotelSearchResponse();

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
            if (auth instanceof AnonymousAuthenticationToken) {
                hotelSearchResponse.setCommission(roleRepository.findByName("ANONYMOUS")
                                                                .getCommission());
            } else {
                hotelSearchResponse.setCommission(roleRepository.findByName(auth.getAuthorities()
                                                                                .iterator()
                                                                                .next()
                                                                                .getAuthority())
                                                                .getCommission());
            }
        }
        return hotelSearchResponse;
    }

    /**
     * search offers for a given hotel both localy and from external api (amadeus)
     * 
     * @param hotelId
     * @param checkInDate
     * @param checkOutDate
     * @param rooms the list of adults by room, every element is a room with that number as guests
     * @return HotelSearchResponse object containing one HotelOfferResponse
     * @throws ResponseException
     */
    public HotelSearchResponse hotelOfferSearch(String hotelId, 
                                String checkInDate, 
                                String checkOutDate, 
                                List<Integer> rooms,
                                Authentication auth) throws ResponseException{
    
        int roomQuantity = rooms.size();
        int adults = rooms.stream().collect(Collectors.summingInt(Integer::intValue));
        HotelOffer h = amadeusService.hotelOfferSearch(hotelId, checkInDate, checkOutDate, adults, roomQuantity);
        HotelSearchResponse sr = new HotelSearchResponse(List.of(HotelOfferResponse.extractHotelOfferResponses(h)) ,
                                                         null, 
                                                         Dictionarie.extractdiDictionarie(h),
                                                         null);
        if (auth instanceof AnonymousAuthenticationToken) {
            sr.setCommission(roleRepository.findByName("ANONYMOUS")
                                                            .getCommission());
        } else {
            sr.setCommission(roleRepository.findByName(auth.getAuthorities()
                                                                            .iterator()
                                                                            .next()
                                                                            .getAuthority())
                                                            .getCommission());
        }
        return sr;
    }

    /**
     * searches the availibility of an offer abd returns it if its available
     * 
     * @param offerId
     * @return HotelSearchResponse with one HotelOffer
     * @throws ResponseException
     */
    public HotelSearchResponse hotelOfferAvailibility(String offerId, Authentication auth) throws ResponseException{
    
        HotelOffer h = amadeusService.hotelOfferAvailibility(offerId);
        System.out.println(h);
        HotelSearchResponse sr = new HotelSearchResponse(List.of(HotelOfferResponse.extractHotelOfferResponses(h)) ,
                                                         null, 
                                                         Dictionarie.extractdiDictionarie(h),
                                                         null);

        if (auth instanceof AnonymousAuthenticationToken) {
            sr.setCommission(roleRepository.findByName("ANONYMOUS")
                                                            .getCommission());
        } else {
            sr.setCommission(roleRepository.findByName(auth.getAuthorities()
                                                                            .iterator()
                                                                            .next()
                                                                            .getAuthority())
                                                            .getCommission());
        }
        return sr;
    }

    /**
     * bookes the offer and returns the confirmation object
     * 
     * @param bookingRequest
     * @return HotelBooking
     * @throws ResponseException
     */
    public HotelBooking bookOffer(HotelBookingRequest bookingRequest) throws ResponseException {
        return amadeusService.hotelOfferBooking(bookingRequest);
    }
}
