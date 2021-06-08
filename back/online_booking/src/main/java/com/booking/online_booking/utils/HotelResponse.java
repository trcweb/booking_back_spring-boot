package com.booking.online_booking.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.amadeus.resources.HotelOffer.Hotel;
import com.amadeus.resources.HotelOffer.MediaURI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelResponse {
    private String id_hotel;
    private Integer nbr_etoile;
    private String nom;
    private String addresse;
    private String pays;
    private String ville_code_iata;
    private String description;
    private List<String> amenities;
    private List<String> media;
    private String fix;
    private String fax;
    private String mobile;
    private String responsable_hotel;
    private String email_responsable;
    private String email_hotel;
    private String etat_hotel;

    public static HotelResponse extracHotelResponse(Hotel h){
        HotelResponse hr = new HotelResponse();
        if (h != null) {
            hr.setId_hotel(h.getHotelId());
            hr.setNbr_etoile(h.getRating());
            hr.setNom(h.getName());
            if (h.getAddress() != null) {
                if (h.getAddress().getLines() != null) {
                    hr.setAddresse(h.getAddress().getLines()[0]);
                }
                hr.setPays(h.getAddress().getCountryCode());
            }
            hr.setVille_code_iata(h.getCityCode());
            if (h.getDescription() != null) {
                hr.setDescription(h.getDescription().getText());
            }
            if (h.getAmenities() != null && h.getAmenities().length > 0) {
                hr.setAmenities(Arrays.asList(h.getAmenities()));
            }
            if (h.getMedia() != null && h.getMedia().length > 0) {
                hr.setMedia(Arrays.asList(h.getMedia())
                                .stream()
                                .map(MediaURI::getUri)
                                .collect(Collectors.toList()));
            }
            if (h.getContact() != null) {
                hr.setFix(h.getContact().getPhone());
                hr.setFix(h.getContact().getFax());
            }
        }
        
        
        return hr;
    }
}
