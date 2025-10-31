package com.example.tpfoyer.controller;

import com.example.tpfoyer.entity.Bloc;
import com.example.tpfoyer.entity.Chambre;
import com.example.tpfoyer.service.ChambreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/chambre")
public class ChambreController {
    @Autowired
    ChambreServiceImpl chambreService;

    @GetMapping
    public List<Chambre> getChambre() {
        return chambreService.getChambre();
    }
}
