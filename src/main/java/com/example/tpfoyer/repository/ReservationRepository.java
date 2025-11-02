package com.example.tpfoyer.repository;

import com.example.tpfoyer.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
