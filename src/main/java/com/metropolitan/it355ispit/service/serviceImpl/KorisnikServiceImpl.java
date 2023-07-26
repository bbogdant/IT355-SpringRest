package com.metropolitan.it355ispit.service.serviceImpl;

import com.metropolitan.it355ispit.model.Korisnik;
import com.metropolitan.it355ispit.repository.KorisnikRepository;
import com.metropolitan.it355ispit.service.KorisnikService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class KorisnikServiceImpl implements KorisnikService {

    private final KorisnikRepository korisnikRepository;
    @Override
    public List<Korisnik> findAllByIme(String ime) {
        return korisnikRepository.findAllByIme(ime);
    }

    @Override
    public Optional<Korisnik> findByIme(String ime) {
        return korisnikRepository.findByIme(ime);
    }

    @Override
    public List<Korisnik> findAll() {
        return korisnikRepository.findAll();
    }

    @Override
    public Korisnik save(Korisnik korisnik) {
        return korisnikRepository.save(korisnik);
    }

    @Override
    public Korisnik update(Korisnik korisnik) {
        return korisnikRepository.save(korisnik);
    }

    @Override
    public Korisnik findById(Long id) {
        return korisnikRepository.findById(id).orElseThrow(() -> new RuntimeException("Korisnik nije pronadjen"));
    }

    @Override
    public void deleteById(Long id) {
        korisnikRepository.deleteById(id);
    }
}
