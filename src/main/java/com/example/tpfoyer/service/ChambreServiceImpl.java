package com.example.tpfoyer.service;

import com.example.tpfoyer.entity.Chambre;
import com.example.tpfoyer.repository.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChambreServiceImpl implements IChambreService{

    @Autowired
    private ChambreRepository chambreRepository;

    @Override
    public List<Chambre> getChambre() {
        return this.chambreRepository.findAll();
    }
}
