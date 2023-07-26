package com.metropolitan.it355ispit.service;

import com.metropolitan.it355ispit.model.Korisnik;

import java.util.List;
import java.util.Optional;

public interface KorisnikService {

    List<Korisnik> findAllByIme(String ime);

    Optional<Korisnik> findByIme(String ime);

    List<Korisnik> findAll();

    Korisnik save(Korisnik korisnik);

    Korisnik update(Korisnik korisnik);

    Korisnik findById(Long id);

    void deleteById(Long id);
}
