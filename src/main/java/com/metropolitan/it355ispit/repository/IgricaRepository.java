package com.metropolitan.it355ispit.repository;

import com.metropolitan.it355ispit.model.Igrica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IgricaRepository extends JpaRepository<Igrica, Integer> {

    Optional<Igrica> findById(Integer id);

    List<Igrica> findAll();


    List<Igrica> findAllByGodineLessThan(Integer godine);

    List<Igrica> findAllByZanr(String zanr);

    List<Igrica> findAllByGodinaIzdavanjaBetween(Integer donjaGranica, Integer gornjaGranica);


}
