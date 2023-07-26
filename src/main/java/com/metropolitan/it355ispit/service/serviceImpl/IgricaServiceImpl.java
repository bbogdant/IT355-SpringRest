package com.metropolitan.it355ispit.service.serviceImpl;

import com.metropolitan.it355ispit.model.Igrica;
import com.metropolitan.it355ispit.model.Korisnik;
import com.metropolitan.it355ispit.repository.IgricaRepository;
import com.metropolitan.it355ispit.repository.KorisnikRepository;
import com.metropolitan.it355ispit.security.SecurityUtil;
import com.metropolitan.it355ispit.service.IgricaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.auditing.CurrentDateTimeProvider;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class IgricaServiceImpl implements IgricaService {

    private final IgricaRepository igricaRepository;
    private final KorisnikRepository korisnikRepository;

    @Override
    public Optional<Igrica> findById(Integer id) {
        return igricaRepository.findById(id);
    }

    @Override
    public List<Igrica> findAllByGodineLessThan() {
        String ime = SecurityUtil.getSessionUser();
        Korisnik korisnik = korisnikRepository.findByIme(ime).orElseThrow(()->new NoSuchElementException("Not found"));
        Integer trenutnaGod = LocalDate.now().getYear();
        Integer godineDeteta = trenutnaGod - korisnik.getDatumRodjenja().getYear();

        return igricaRepository.findAllByGodineLessThan(godineDeteta);
    }

    @Override
    public List<Igrica> findAllByZanr(String zanr) {
        return igricaRepository.findAllByZanr(zanr);
    }

    @Override
    public List<Igrica> findAllByGodinaIzdavanjaBetween(Integer donjaGranica, Integer gornjaGranica) {
        return igricaRepository.findAllByGodinaIzdavanjaBetween(donjaGranica,gornjaGranica);
    }

    @Override
    public List<Igrica> findAll() {
        return igricaRepository.findAll();
    }

    @Override
    public Igrica updateGodineOpisById(Integer id, String opis, Integer godine) {
       Igrica igricaUpdate = findById(id).orElseThrow(()->new NoSuchElementException("Not found"));
       igricaUpdate.setGodine(godine);
       igricaUpdate.setNaziv(opis);
       return igricaRepository.save(igricaUpdate);
    }


    @Override
    public Igrica save(Igrica igrica) {
        return igricaRepository.save(igrica);
    }

    @Override
    public Igrica update(Igrica igrica) {
        return igricaRepository.save(igrica);
    }

    @Override
    public void deleteById(Integer id) {
        igricaRepository.deleteById(id);

    }
}
