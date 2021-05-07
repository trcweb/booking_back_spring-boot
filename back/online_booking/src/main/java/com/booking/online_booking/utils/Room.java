package com.booking.online_booking.utils;

import java.util.List;

import com.amadeus.resources.HotelOffer.RoomDetails;
import com.google.gson.annotations.Expose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Expose
    private Integer id;
    @Expose
    private String type;
    @Expose
    private String bedType;
    @Expose
    private Integer nbrPersonnes;
    @Expose
    private Integer availableCount;
    @Expose
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
