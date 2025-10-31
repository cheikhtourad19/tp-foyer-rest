package com.example.tpfoyer.service;

import com.example.tpfoyer.entity.Foyer;
import com.example.tpfoyer.repository.FoyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoyerServiceImpl implements IFoyerService{

    @Autowired
    private FoyerRepository foyerRepository;

    @Override
    public List<Foyer> getFoyer() {
        return this.foyerRepository.findAll();
    }
}
