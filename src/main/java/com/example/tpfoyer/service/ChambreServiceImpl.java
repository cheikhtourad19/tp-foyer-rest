package com.example.tpfoyer.service;

import com.example.tpfoyer.entity.Chambre;
import com.example.tpfoyer.entity.TypeChambre;
import com.example.tpfoyer.entity.Universite;
import com.example.tpfoyer.repository.ChambreRepository;
import com.example.tpfoyer.repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChambreServiceImpl implements IChambreService{

    @Autowired
    private ChambreRepository chambreRepository;
    @Autowired
    private UniversiteRepository universiteRepository;

    @Override
    public List<Chambre> getChambre() {
        return this.chambreRepository.findAll();
    }

    @Override
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type) {
        Optional<Universite> universite= universiteRepository.findByNomUniversite(nomUniversite);

        if(universite.isEmpty()){
            throw new RuntimeException("Universite n'existe pas ");
        }
        return chambreRepository.findByReservationIsNullAndBlocFoyerUniversiteNomUniversiteAndTypeC(nomUniversite, type);
    }


}
