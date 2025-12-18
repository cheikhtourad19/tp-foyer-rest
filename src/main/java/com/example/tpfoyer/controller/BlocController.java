package com.example.tpfoyer.controller;

import com.example.tpfoyer.entity.Bloc;
import com.example.tpfoyer.service.BlocServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bloc")
public class BlocController {
    @Autowired
    BlocServiceImpl blocService;

    @GetMapping
    public List<Bloc> getAllBloc() {
        return blocService.getAllBloc();
    }

    @PostMapping("/affecter-chambre-a-bloc/{blocId}")
    Bloc affecterChambreAbloc(@PathVariable Long blocId,@RequestBody List<Long> numChambre)
    {
        return this.blocService.affecterChambreABloc(numChambre,blocId);
    }
}
