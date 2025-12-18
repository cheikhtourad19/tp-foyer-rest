package com.example.tpfoyer.service;

import com.example.tpfoyer.entity.Bloc;
import com.example.tpfoyer.entity.Chambre;
import com.example.tpfoyer.repository.BlocRepository;
import com.example.tpfoyer.repository.ChambreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
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
        List<Chambre> chambres = chambreRepository.findByNumeroChambreIn(numChambre);
        if(chambres.size()!=numChambre.size()) {
            throw new RuntimeException("Une ou plusieur chambre n'existe pas ");
        }
        chambres.forEach(chambre->
                {
                    if (chambre.getBloc().getIdBloc()==null) {
                        bloc.getChambres().add(chambre);
                    } else {
                        if (chambre.getBloc().getIdBloc()!=idBloc) {
                            throw new RuntimeException("Chambre appartient a d'autre bloc");
                        }
                    }
                }
        );
        return blocRepository.save(bloc);
    }


    @Scheduled(cron = "*/15 * * * * * ")
    void listeChambresParBloc(){
        List<Bloc> blocs = this.blocRepository.findAll();
        if(!blocs.isEmpty()){
            log.info("nombre de bloc :" + blocs.size());
            for(Bloc bloc : blocs){
                log.info(bloc.toString());
                if (!bloc.getChambres().isEmpty()){
                    bloc.getChambres().forEach(chambres -> {
                        log.info(chambres.toString());
                    });
                }else {
                    log.info("bloc vides");
                }
            }
        }else {
            log.info("Liste des Blocs vide");
        }
    }
}
