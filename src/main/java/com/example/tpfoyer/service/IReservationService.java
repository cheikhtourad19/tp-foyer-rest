package com.example.tpfoyer.service;

import com.example.tpfoyer.entity.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationService {

    List<Reservation> getReservation();

    Reservation ajouterReservation(long idBloc, String cinEtudiant);
    Reservation annulerReservation(long cinEtudiant);
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversite, String nomUniversite);
}
