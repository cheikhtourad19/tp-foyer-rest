package com.example.tpfoyer.repository;

import com.example.tpfoyer.entity.Etudiant;
import com.example.tpfoyer.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Reservation findByEtudiantsContains(Etudiant etudiant);
    List<Reservation> findByAnneeUniversiteAndChambreBlocFoyerUniversiteNomUniversite(Date annee,String nomUniversite);
}
