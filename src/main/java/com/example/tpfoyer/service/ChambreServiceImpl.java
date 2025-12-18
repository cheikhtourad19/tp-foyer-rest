package com.example.tpfoyer.service;

import com.example.tpfoyer.entity.Bloc;
import com.example.tpfoyer.entity.Chambre;
import com.example.tpfoyer.entity.TypeChambre;
import com.example.tpfoyer.entity.Universite;
import com.example.tpfoyer.repository.ChambreRepository;
import com.example.tpfoyer.repository.UniversiteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ChambreServiceImpl implements IChambreService {

    @Autowired
    private ChambreRepository chambreRepository;
    @Autowired
    private UniversiteRepository universiteRepository;

    @Override
    public List<Chambre> getChambre() {
        return this.chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre chambre) {
        this.chambreRepository.save(chambre);
        return chambre;
    }

    @Override
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type) {
        Optional<Universite> universite = universiteRepository.findByNomUniversite(nomUniversite);

        if (universite.isEmpty()) {
            throw new RuntimeException("Universite n'existe pas ");
        }
        return chambreRepository.findByReservationIsNullAndBlocFoyerUniversiteNomUniversiteAndTypeC(nomUniversite, type);
    }

    @Scheduled(cron = "*/15 * * * * * ")
    public void afficherNombreChambreWithHashMap() {
        List<Chambre> chambres = this.chambreRepository.findAll();
        System.out.println("nombre de chambres : " + chambres.size());
        HashMap<String, Integer> chambreHashMapCount = new HashMap<>();
        for (Chambre chambre : chambres) {
            String type = String.valueOf(chambre.getTypeC());
            chambreHashMapCount.put(type, chambreHashMapCount.getOrDefault(type, 0) + 1);
        }

        chambreHashMapCount.forEach((type, count) -> log.info(type + " : " + count + " Pourcentage : " + (count * 100.0) / chambres.size()));
    }


}

