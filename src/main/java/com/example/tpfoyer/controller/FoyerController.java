package com.example.tpfoyer.controller;

import com.example.tpfoyer.entity.Bloc;
import com.example.tpfoyer.entity.Foyer;
import com.example.tpfoyer.service.FoyerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/foyer")
public class FoyerController {

    @Autowired
    FoyerServiceImpl foyerService;

    @GetMapping
    public List<Foyer> getFoyer() {
        return foyerService.getFoyer();
    }
}
