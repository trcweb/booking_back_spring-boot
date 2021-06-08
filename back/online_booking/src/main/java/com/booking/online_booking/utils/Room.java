package com.booking.online_booking.utils;

import java.util.List;

import com.amadeus.resources.HotelOffer.RoomDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
                             null, 
                             null, 
                             null, 
                             null);
        if(r.getTypeEstimated() != null){
            room.setBedType(r.getTypeEstimated().getBedType());
        }
                            
        return List.of(room);
    }
}
