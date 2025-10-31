package com.example.tpfoyer.controller;

import com.example.tpfoyer.entity.Foyer;
import com.example.tpfoyer.entity.Reservation;
import com.example.tpfoyer.service.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
