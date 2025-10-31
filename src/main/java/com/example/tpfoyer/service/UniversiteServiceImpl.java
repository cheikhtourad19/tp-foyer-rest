package com.example.tpfoyer.service;

import com.example.tpfoyer.entity.Universite;
import com.example.tpfoyer.repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniversiteServiceImpl implements IUniversiteService {

    @Autowired
    private UniversiteRepository universiteRepository;

    @Override
    public Universite getUniversite() {
        return universiteRepository.findAll().get(0);
    }
}
