package com.metropolitan.it355ispit.service.serviceImpl;

import com.metropolitan.it355ispit.model.Korisnik;
import com.metropolitan.it355ispit.model.Rola;

import com.metropolitan.it355ispit.model.TipKorisnika;
import com.metropolitan.it355ispit.repository.KorisnikRepository;
import com.metropolitan.it355ispit.security.jwt.JwtService;
import com.metropolitan.it355ispit.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;
    private final KorisnikRepository korisnikRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public String login(String ime, String lozinka) {
        Korisnik korisnik = korisnikRepository.findByIme(ime).orElseThrow(RuntimeException::new);

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(ime, lozinka)
            );
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Pogresna sifra");
        }
        return jwtService.generateToken(korisnik);
    }

    @Override
    public String register(String ime, String prezime, LocalDate datum, String adresa, Rola rola, String username, String lozinka) {
        Korisnik korisnik = new Korisnik();
        korisnik.setIme(ime);
        korisnik.setPrezime(prezime);
        korisnik.setDatumRodjenja(datum);
        korisnik.setAdresa(adresa);
        korisnik.setRola(rola);
        korisnik.setUsername(username);
        korisnik.setLozinka(passwordEncoder.encode(lozinka));
        korisnikRepository.save(korisnik);

        return jwtService.generateToken(korisnik);
    }
}