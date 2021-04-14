package com.booking.online_booking.utils;

import java.util.List;

import com.amadeus.resources.HotelOffer.RoomDetails;
import com.booking.online_booking.model.Typologie;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Room {
    private Integer id;
    private String type;
    private String bedType;
    private Integer nbrPersonnes;
    private Integer availableCount;
    private Integer requestedCount;

    public static List<Room> extractRoom(RoomDetails r){
        Room room = new Room(null,
                             r.getType(), 
                             r.getTypeEstimated().getBedType(), 
                             null, 
                             null, 
                             null);
        return List.of(room);
    }
}
