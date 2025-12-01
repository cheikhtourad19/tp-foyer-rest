package com.example.tpfoyer.service;

import com.example.tpfoyer.entity.Bloc;
import com.example.tpfoyer.entity.Chambre;

import java.util.List;

public interface IBlocService {

    List<Bloc> getAllBloc();
    //Bloc affecterChambreABloc(List<Long> numChambre,long idBloc);

}
