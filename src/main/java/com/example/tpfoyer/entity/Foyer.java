package com.example.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Foyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;
    private String nomFoyer;
    private Long capaciteFoer;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "foyer")
    private Set<Bloc> blocs;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "foyer")
    private Universite universite;
}
