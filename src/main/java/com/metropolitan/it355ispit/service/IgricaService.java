package com.metropolitan.it355ispit.service;

import com.metropolitan.it355ispit.model.Igrica;
import com.metropolitan.it355ispit.model.Korisnik;


import java.util.List;
import java.util.Optional;

public interface IgricaService {

    Optional<Igrica> findById(Integer id);

    List<Igrica> findAllByGodineLessThan();

    List<Igrica> findAllByZanr(String zanr);

    List<Igrica> findAllByGodinaIzdavanjaBetween(Integer donjaGranica, Integer gornjaGranica);

    List<Igrica> findAll();



    Igrica updateGodineOpisById(Integer id, String opis, Integer godine);

    Igrica save(Igrica igrica);

    Igrica update(Igrica igrica);

    void deleteById(Integer id);
}
