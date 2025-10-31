package com.example.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Bloc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;
    private String nomBloc;
    private Long capaciteBloc;

    @ManyToOne()
    private Foyer foyer;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "bloc", fetch = FetchType.EAGER)
    private Set<Chambre> chambres;
}





