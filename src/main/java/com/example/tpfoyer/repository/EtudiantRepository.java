package com.example.tpfoyer.repository;

import com.example.tpfoyer.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    Etudiant findByCin(String cin);
}
