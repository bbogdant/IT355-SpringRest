package com.metropolitan.it355ispit.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ocena")
public class Ocena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "IGRICA_FK", nullable = false)
    private Igrica igricaFk;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "KORISNIK_FK", nullable = false)
    private Korisnik korisnikFk;

    @Column(name = "OCENA", nullable = false)
    private Integer ocena;

    @Column(name = "KOMENTAR", length = 100)
    private String komentar;

}