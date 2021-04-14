package com.booking.online_booking.utils;

import java.util.ArrayList;
import java.util.List;

import com.amadeus.resources.HotelOffer.Offer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferResponse {
    private String id;
    private int roomQuantity;
    private List<Room> rooms;
    private int guests;
    private String currency;
    private double total;
    private String paymentType;
    private String cancellationDeadline;;
    private String cancellationAmmount;

    public static List<OfferResponse> extractOffers(List<Offer> offers) {
        List<OfferResponse> resp = new ArrayList<>();
        for (Offer offer : offers) {
            OfferResponse or = new OfferResponse();
            or.setId(offer.getId());
            or.setRoomQuantity(offer.getRoomQuantity());
            or.setRooms(Room.extractRoom(offer.getRoom()));
            or.setGuests(offer.getGuests().getAdults());
            or.setCurrency(offer.getPrice().getCurrency());
            or.setTotal(Double.parseDouble(offer.getPrice().getTotal()));
            //or.setPaymentType(offer.getPolicies().);
        }
        return null;
    }
}
