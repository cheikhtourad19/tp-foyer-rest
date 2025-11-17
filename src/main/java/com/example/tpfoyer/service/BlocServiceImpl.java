package com.example.tpfoyer.service;

import com.example.tpfoyer.entity.Bloc;
import com.example.tpfoyer.entity.Chambre;
import com.example.tpfoyer.repository.BlocRepository;
import com.example.tpfoyer.repository.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BlocServiceImpl implements IBlocService{

    @Autowired
    private BlocRepository blocRepository;

    @Autowired
    ChambreRepository chambreRepository;

    @Override
    public List<Bloc> getAllBloc() {
        return this.blocRepository.findAll();
    }

    @Override
    public Bloc affecterChambreABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElseThrow(()->new RuntimeException("Bloc n'existe pas"));
        if (bloc.getChambres()==null) {
            bloc.setChambres(new ArrayList<>());
        }
        numChambre.forEach(chambre->{
            chambreRepository.findBynumerochambre(chambre)
                    .ifPresent(
                    ch -> {
                        if (!ch.getBloc().getIdBloc().equals(idBloc)) {
                            bloc.getChambres().add(ch);
                        }
                    }
            );

        });
        return blocRepository.save(bloc);
    }
}
