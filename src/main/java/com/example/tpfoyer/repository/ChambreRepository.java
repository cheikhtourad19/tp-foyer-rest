package com.example.tpfoyer.repository;

import com.example.tpfoyer.entity.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    Optional<Chambre> findBynumerochambre(Long numChambre);
    List<Chambre> findAllBynumerochambre(List<Long>numerochambre);
}
