package com.booking.online_booking.controller;

import java.util.List;

import javax.validation.Valid;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.HotelBooking;
import com.amadeus.resources.Location;
import com.booking.online_booking.service.HotelSearchService;
import com.booking.online_booking.utils.HotelBookingRequest;
import com.booking.online_booking.utils.HotelSearchResponse;
import com.booking.online_booking.utils.NextPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/hotels")
public class HotelsController {

    @Autowired
    HotelSearchService hotelSearchService;

    /**
     * airport and cities search autocomplete
     * 
     * @param searchTerm the term to pass as search subject
     * @param subType the type of location: CITY, AIRPORT or both
     * @return list of matched locations
     * @throws ResponseException
     */
    @GetMapping("/airport-cities-search/{st}/{sub}")
    public List<Location> airportAndCitySearch(@PathVariable("st") String searchTerm, @PathVariable("sub") String subType) throws ResponseException {
        return hotelSearchService.airportAndCitySearch(searchTerm, subType);
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
    @PostMapping("/searchOffers/{cityCode}/{checkInDate}/{checkOutDate}/{rooms}")
    public HotelSearchResponse searchOffers(@PathVariable("cityCode") String cityCode,
                                            @PathVariable("checkInDate") String checkInDate,
                                            @PathVariable("checkOutDate") String checkOutDate,
                                            @PathVariable("rooms") List<Integer> rooms,
                                            @RequestParam(name="ratings", required = false) List<Integer> ratings,
                                            @RequestParam(name="priceRange", required = false) int[] priceRange,
                                            @RequestBody NextPage next,
                                            Authentication auth) throws ResponseException{
        
        return hotelSearchService.searchOffers(cityCode, checkInDate, checkOutDate, rooms, ratings, priceRange, next, auth);
    }

    /**
     * search offers for a given hotel both localy and from external api (amadeus)
     * 
     * @param hotelId
     * @param checkInDate
     * @param checkOutDate
     * @param rooms
     * @return
     * @throws ResponseException
     */
    @GetMapping("/hotelOfferSearch/{hotelId}/{checkInDate}/{checkOutDate}/{rooms}")
    public HotelSearchResponse hotelOfferSearch(@PathVariable("hotelId") String hotelId, 
                                                @PathVariable("checkInDate") String checkInDate, 
                                                @PathVariable("checkOutDate") String checkOutDate, 
                                                @PathVariable("rooms") List<Integer> rooms,
                                                Authentication auth) throws ResponseException {
        return hotelSearchService.hotelOfferSearch(hotelId, checkInDate, checkOutDate, rooms, auth);
    }

    /**
     * searches the availibility of an offer abd returns it if its available
     * 
     * @param offerId
     * @return HotelSearchResponse with one HotelOffer
     * @throws ResponseException
     */
    @GetMapping("/hotelOfferAvailibility/{offerId}")
    public HotelSearchResponse hotelOfferAvailibility(@PathVariable("offerId") String offerId, Authentication auth) throws ResponseException{
    
        return hotelSearchService.hotelOfferAvailibility(offerId, auth);
    }

    /**
     * bookes the offer and returns the confirmation object
     * 
     * @param bookingRequest
     * @return HotelBooking
     * @throws ResponseException
     */
    @PostMapping("/hotel-booking")
    public HotelBooking bookOffer(@RequestBody @Valid HotelBookingRequest bookingRequest) throws ResponseException {
        return hotelSearchService.bookOffer(bookingRequest);
    }
}
