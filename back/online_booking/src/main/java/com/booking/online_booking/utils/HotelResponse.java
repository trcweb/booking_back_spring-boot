package com.booking.online_booking.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.amadeus.resources.HotelOffer.Hotel;
import com.amadeus.resources.HotelOffer.MediaURI;
import com.google.gson.annotations.Expose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelResponse {
    @Expose
    private String id_hotel;
    @Expose
    private Integer nbr_etoile;
    @Expose
    private String nom;
    @Expose
    private String addresse;
    @Expose
    private String pays;
    @Expose
    private String ville_code_iata;
    @Expose
    private String description;
    @Expose
    private List<String> amenities;
    @Expose
    private List<String> media;
    @Expose
    private String fix;
    @Expose
    private String fax;
    @Expose
    private String mobile;
    @Expose
    private String responsable_hotel;
    @Expose
    private String email_responsable;
    @Expose
    private String email_hotel;
    @Expose
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
