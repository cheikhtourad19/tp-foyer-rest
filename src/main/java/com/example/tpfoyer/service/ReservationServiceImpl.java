package com.example.tpfoyer.service;

import com.example.tpfoyer.entity.Reservation;
import com.example.tpfoyer.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements IReservationService {
    @Autowired
    private ReservationRepository reservationRepository;


    @Override
    public List<Reservation> getReservation() {
        return this.reservationRepository.findAll();
    }
}
