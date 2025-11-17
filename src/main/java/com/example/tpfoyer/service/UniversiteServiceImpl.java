package com.example.tpfoyer.service;

import com.example.tpfoyer.entity.Foyer;
import com.example.tpfoyer.entity.Universite;
import com.example.tpfoyer.repository.FoyerRepository;
import com.example.tpfoyer.repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniversiteServiceImpl implements IUniversiteService {

    @Autowired
    private UniversiteRepository universiteRepository;
    @Autowired
    private FoyerRepository foyerRepository;
    @Override
    public Universite getUniversite() {
        return universiteRepository.findAll().get(0);
    }

    @Override
    public Universite affecterFoyerAUniversite(Long idFoyer, String nomUniversite) {
        Universite universite =universiteRepository.findByNomUniversite(nomUniversite).orElseThrow(()-> new RuntimeException(" universite n'existe pas"));
        Foyer foyer =foyerRepository.findById(idFoyer).orElseThrow(()-> new RuntimeException("foyer n'existe pas"));

        if (foyer.getUniversite()!=null||universite.getFoyer()!=null){
            throw new RuntimeException("ces elements ont deja ete affecter");
        }

        universite.setFoyer(foyer);
        foyer.setUniversite(universite);
        universiteRepository.save(universite);
        foyerRepository.save(foyer);
        return universite;
    }

    @Override
    public Universite desAffecterFoyerAUniversite(Long idUniversite) {
       Universite universite = universiteRepository.findById(idUniversite).orElseThrow(()-> new RuntimeException("universite n'existe pas"));
       Foyer foyer = universite.getFoyer();
       if (foyer==null){
           throw new RuntimeException("universite n'a pas de foyer");
       }
       universite.setFoyer(null);
       foyer.setUniversite(null);
       universiteRepository.save(universite);
       foyerRepository.save(foyer);
       return universite ;
    }


}
