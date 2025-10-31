package com.example.tpfoyer.service;

import com.example.tpfoyer.entity.Bloc;
import com.example.tpfoyer.repository.BlocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlocServiceImpl implements IBlocService{

    @Autowired
    private BlocRepository blocRepository;

    @Override
    public List<Bloc> getAllBloc() {
        return this.blocRepository.findAll();
    }
}
