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
    private double base;
    private double total;
    private String paymentType;
    private String cancellationDeadline;
    private double cancellationAmmount;

    public static List<OfferResponse> extractOffers(Offer[] offers) {
        List<OfferResponse> resp = new ArrayList<>();
        int rooms = 1;
        for (Offer offer : offers) {
            OfferResponse or = new OfferResponse();
            or.setId(offer.getId());
            try {
                rooms = offer.getRoomQuantity().intValue();
            } catch (Exception e) {
            }
            or.setRoomQuantity(rooms);
            or.setBoardType(offer.getBoardType());
            or.setRooms(Room.extractRoom(offer.getRoom()));
            or.setGuests(offer.getGuests().getAdults());
            or.setCurrency(offer.getPrice().getCurrency());
            try {
                or.setBase(Double.parseDouble(offer.getPrice().getVariations().getAverage().getBase()));
            } catch (Exception e) {
            }
            or.setTotal(Double.parseDouble(offer.getPrice().getTotal()));
            //payment methode
            try {
                or.setPaymentType(offer.getPolicies().getGuarantee().getAcceptedPayments().getMethod());
            } catch (Exception e) {
            }
            try {
                or.setPaymentType(offer.getPolicies().getDeposit().getAcceptedPayments().getMethod());
            } catch (Exception e) {
            }
            try {
                or.setPaymentType(offer.getPolicies().getPrepay().getAcceptedPayments().getMethod());
            } catch (Exception e) {
            }
            try {
                or.setPaymentType(offer.getPolicies().getHoldTime().getAcceptedPayments().getMethod());
            } catch (Exception e) {
            }
            // cancellation
            try {
                or.setCancellationDeadline(offer.getPolicies().getCancellation().getDeadline());
            } catch (Exception e) {
            }
            try {
                or.setCancellationAmmount(Double.parseDouble(offer.getPolicies().getCancellation().getAmount()));
            } catch (Exception e) {
            }
            resp.add(or);
        }
        return resp;
    }
}
