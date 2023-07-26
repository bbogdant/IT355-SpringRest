package com.metropolitan.it355ispit.service;

import com.metropolitan.it355ispit.model.Rola;
import com.metropolitan.it355ispit.model.TipKorisnika;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
import java.util.Date;

public interface AuthService {
    String login(String email, String lozinka);

    String register(String ime, String prezime, LocalDate datum, String adresa, Rola rola, String username, String lozinka);
}