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
    private String boardType;
    private List<Room> rooms;
    private int guests;
    private String currency;
    private String base;
    private double total;
    private String paymentType;
    private String cancellationDeadline;
    private String cancellationAmmount;

    public static List<OfferResponse> extractOffers(Offer[] offers) {
        List<OfferResponse> resp = new ArrayList<>();
        for (Offer offer : offers) {
            OfferResponse or = new OfferResponse();
            or.setId(offer.getId());
            or.setRoomQuantity(offer.getRoomQuantity());
            or.setBoardType(offer.getBoardType());
            or.setRooms(Room.extractRoom(offer.getRoom()));
            or.setGuests(offer.getGuests().getAdults());
            or.setCurrency(offer.getPrice().getCurrency());
            or.setBase(offer.getPrice().getVariations().getAverage().getBase());
            or.setTotal(Double.parseDouble(offer.getPrice().getTotal()));
            //or.setPaymentType(offer.getPolicies().getGuarantee().getAcceptedPayments().getMethod());
            or.setCancellationDeadline(offer.getPolicies().getCancellation().getDeadline());
            or.setCancellationAmmount(offer.getPolicies().getCancellation().getAmount());
            resp.add(or);
        }
        return resp;
    }
}
