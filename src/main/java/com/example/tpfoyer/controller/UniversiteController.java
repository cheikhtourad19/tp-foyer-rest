package com.example.tpfoyer.controller;


import com.example.tpfoyer.entity.Foyer;
import com.example.tpfoyer.entity.Universite;
import com.example.tpfoyer.service.UniversiteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/universite")
public class UniversiteController {

    @Autowired
    UniversiteServiceImpl universiteService;


    @GetMapping
    public Universite getUniversite() {
        return universiteService.getUniversite();
    }
}
