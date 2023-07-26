package com.metropolitan.it355ispit.repository;

import com.metropolitan.it355ispit.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

    List<Korisnik> findAllByIme(String ime);

    Optional<Korisnik> findByIme(String ime);

    Optional<Korisnik> findByUsername(String username);
}
