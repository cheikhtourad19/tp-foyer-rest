package com.example.tpfoyer.repository;

import com.example.tpfoyer.entity.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UniversiteRepository extends JpaRepository<Universite, Long> {

    Optional<Universite> findByNomUniversite(String nomUniversite);
}
