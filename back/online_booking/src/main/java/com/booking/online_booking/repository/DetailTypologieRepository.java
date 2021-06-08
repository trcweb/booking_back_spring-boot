package com.booking.online_booking.repository;

import com.booking.online_booking.model.DetailTypologie;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailTypologieRepository extends JpaRepository<DetailTypologie, Integer>{
    
    public static final String SEARCH = "SELECT detail_typologie.* from(SELECT dt.* FROM detail_typologie dt INNER JOIN typologie t " + 
                                       "ON t.id_typologie = dt.id_typologie AND t.nbr_personnes = :nbr_personnes WHERE " +
                                       "dt.id_detailhotel IN (SELECT dh.id_detailhotel from detail_hotel dh " + 
                                       "INNER JOIN hotel h ON h.id_hotel=dh.id_hotel AND dh.date_debut <= :date_debut AND h.ville_code_iata = :code_ville) " + 
                                       "GROUP BY dt.id_detailhotel, dt.prix_typologie ASC) as detail_typologie GROUP BY detail_typologie.id_detailhotel ORDER BY detail_typologie.prix_typologie ASC";
    @Query(value = SEARCH, nativeQuery = true)
    Slice<DetailTypologie> searchOffers(
                                        @Param("nbr_personnes") int nbr_per,
                                        @Param("date_debut") String date_debut,
                                        @Param("code_ville") String code_ville,
                                        Pageable pageable);
}
