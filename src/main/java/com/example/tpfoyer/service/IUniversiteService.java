package com.example.tpfoyer.service;

import com.example.tpfoyer.entity.Universite;

public interface IUniversiteService {


    public Universite getUniversite();
    Universite affecterFoyerAUniversite(Long idFoyer,String nomUniversite);
}
