package com.metropolitan.it355ispit.controller;


import com.metropolitan.it355ispit.model.Rola;
import com.metropolitan.it355ispit.model.TipKorisnika;
import com.metropolitan.it355ispit.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RequiredArgsConstructor
@RequestMapping("/api/auth")
@RestController
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String lozinka) {
        return authService.login(email, lozinka);
    }

    @PostMapping("/register")
    public String register(@RequestParam String ime,
                           @RequestParam String prezime,
                           @RequestParam LocalDate datum,
                           @RequestParam String adresa,
                           @RequestParam Rola rola,
                           @RequestParam String username,
                           @RequestParam String lozinka) {
        return authService.register(ime, prezime, datum, adresa, rola, username, lozinka);
    }
}
