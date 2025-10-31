package com.example.tpfoyer.controller;

import com.example.tpfoyer.entity.Bloc;
import com.example.tpfoyer.entity.Etudiant;
import com.example.tpfoyer.service.EtudiantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/etudiant")
public class EtudiantController {
    @Autowired
    EtudiantServiceImpl etudiantService;

    @GetMapping
    public List<Etudiant> getEtudiant() {
        return etudiantService.getEtudiant();
    }
}
