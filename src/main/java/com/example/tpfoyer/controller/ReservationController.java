package com.example.tpfoyer.controller;

import com.example.tpfoyer.entity.Foyer;
import com.example.tpfoyer.entity.Reservation;
import com.example.tpfoyer.entity.TypeChambre;
import com.example.tpfoyer.service.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    ReservationServiceImpl reservationService;

    @GetMapping
    public List<Reservation> getReservation() {
        return reservationService.getReservation();
    }
    @GetMapping("/getReservation")
    public List<Reservation> getReservationByFoyerId(@RequestParam Date anneeUniversite, @RequestParam String nomUniversite) {
        return this.reservationService.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversite, nomUniversite);

    }
    @PostMapping
    public Reservation ajouterReservation(@RequestBody long idBloc, @RequestBody long cinEtudiant) {
        return this.reservationService.ajouterReservation(idBloc,cinEtudiant);
    }
    @PutMapping
    public Reservation annulerReservation(@RequestBody long cinEtudiant) {
        return reservationService.annulerReservation(cinEtudiant);
    }




}
