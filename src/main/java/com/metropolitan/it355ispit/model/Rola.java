package com.metropolitan.it355ispit.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
@Table(name = "rola")
public class Rola {

    public static final String USER = "DETE";
    public static final String ADMIN = "RODITELJ";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "TIP_KORISNIKA", nullable = false, length = 20)
    private String tipKorisnika;



}