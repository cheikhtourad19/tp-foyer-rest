package com.example.tpfoyer.service;

import com.example.tpfoyer.entity.Chambre;
import com.example.tpfoyer.entity.TypeChambre;

import java.util.List;

public interface IChambreService {

    List<Chambre> getChambre();
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type);
}
