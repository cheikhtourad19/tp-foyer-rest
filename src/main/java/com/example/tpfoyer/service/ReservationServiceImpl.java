package com.example.tpfoyer.service;

import com.example.tpfoyer.entity.*;
import com.example.tpfoyer.repository.BlocRepository;
import com.example.tpfoyer.repository.ChambreRepository;
import com.example.tpfoyer.repository.EtudiantRepository;
import com.example.tpfoyer.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class ReservationServiceImpl implements IReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private BlocRepository blocRepository;
    @Autowired
    private ChambreRepository chambreRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public List<Reservation> getReservation() {
        return this.reservationRepository.findAll();
    }


    @Override
    public Reservation ajouterReservation(long idBloc, String cinEtudiant) {
        Bloc bloc = blocRepository.findById(idBloc).orElseThrow(()->new RuntimeException("bloc n'existe pas"));
        List <Chambre> chambres = chambreRepository.findAllByBloc(bloc);

        if(chambres.isEmpty()){
            throw new RuntimeException("Pas de chambre pour ce bloc");
        }
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);
        if(etudiant == null){
            throw new RuntimeException("Pas de etudiant pour ce cin");
        }
        Chambre chambre = null;
        for (Chambre ch : chambres) {
            if (
                    ch.getTypeC().equals(TypeChambre.SIMPLE)&&ch.getReservation().isEmpty()
                            || ch.getTypeC().equals(TypeChambre.DOUBLE)&&ch.getReservation().size()<2
                            || ch.getTypeC().equals(TypeChambre.TRIPE)&&ch.getReservation().size()<3
            ){
                chambre=ch;
                break;
            }
        }
        if (chambre==null){
            throw new RuntimeException("Chambre pleine");
        }
        Reservation reservation = new Reservation();
        reservation.setEstValide(true);
        reservation.setChambre(chambre);
        reservation.setAnneUnniversitaire(new Date(2025));
        reservation.setEtudiants((List<Etudiant>) etudiant);
        chambre.setReservation((Set<Reservation>) reservation);
        reservationRepository.save(reservation);
        chambreRepository.save(chambre);

        return reservation;
    }

    @Override
    public Reservation annulerReservation(long cinEtudiant) {
        Etudiant etudiant = etudiantRepository.findByCin(String.valueOf(cinEtudiant));
        if(etudiant==null){
            throw new RuntimeException("Pas de etudiant pour ce cin");
        }
        Reservation reservation = reservationRepository.findByEtudiantsContains(etudiant);
        if(reservation==null){
            throw new RuntimeException("Pas de reservation");
        }
        Chambre chambre = reservation.getChambre();
        reservation.setEstValide(false);
        reservation.setEtudiants(null);
        reservation.setChambre(null);
        chambre.getReservation().remove(reservation);
        chambreRepository.save(chambre);
        reservationRepository.save(reservation);
        return reservation;


    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversite, String nomUniversite) {
        return reservationRepository.findByAnneeUniversiteAndChambreBlocFoyerUniversiteNomUniversite(anneeUniversite,nomUniversite);
    }
}
