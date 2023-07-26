package com.metropolitan.it355ispit.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "igrica")
public class Igrica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "NAZIV", nullable = false, length = 50)
    private String naziv;

    @Column(name = "ZANR", length = 20)
    private String zanr;

    @Column(name = "GODINE", nullable = false)
    private Integer godine;

    @Column(name = "CENA", nullable = false)
    private Double cena;

    @Column(name = "GODINA_IZDAVANJA")
    private Integer godinaIzdavanja;

    @OneToMany(mappedBy = "igricaFk")
    private Set<Ocena> ocenas = new LinkedHashSet<>();

}