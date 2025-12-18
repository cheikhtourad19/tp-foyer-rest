package com.example.tpfoyer.repository;

import com.example.tpfoyer.entity.Bloc;
import com.example.tpfoyer.entity.Chambre;
import com.example.tpfoyer.entity.Reservation;
import com.example.tpfoyer.entity.TypeChambre;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    List<Chambre> findByNumeroChambreIn(List <Long> numerochambre);

    List<Chambre> findAllByBloc(Bloc bloc);
    Chambre findByReservationContains(Reservation reservation);

    List<Chambre> findByReservationIsNullAndBlocFoyerUniversiteNomUniversiteAndTypeC(String nomUniversite, TypeChambre typeC);
}
