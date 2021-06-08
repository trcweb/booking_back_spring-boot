package com.booking.online_booking.service;

import com.booking.online_booking.model.DetailTypologie;
import com.booking.online_booking.repository.DetailTypologieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class DetailTypologieService {
    
    @Autowired
    private DetailTypologieRepository detailTypologieRepository;

    public Slice<DetailTypologie> searchByCityAndDateAndNbr(int nbr_personnes, String date_debut, String code_ville, int page_number){
        Pageable page = PageRequest.of(page_number, 10);
        Slice<DetailTypologie> details =  detailTypologieRepository.searchOffers(nbr_personnes, date_debut, code_ville, page);
        return details;
    }
}
