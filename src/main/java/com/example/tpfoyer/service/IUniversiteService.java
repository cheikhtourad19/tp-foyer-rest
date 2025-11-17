package com.example.tpfoyer.service;

import com.example.tpfoyer.entity.Universite;

public interface IUniversiteService {


    Universite getUniversite();
    Universite affecterFoyerAUniversite(Long idFoyer,String nomUniversite);
    boolean desAffecterFoyerAUniversite(Long idFoyer,String nomUniversite);
}
