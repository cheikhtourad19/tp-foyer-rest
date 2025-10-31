package com.example.tpfoyer.service;

import com.example.tpfoyer.entity.Etudiant;
import com.example.tpfoyer.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantServiceImpl implements IEtudiantService{
    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public List<Etudiant> getEtudiant() {
        return this.etudiantRepository.findAll();
    }
}
