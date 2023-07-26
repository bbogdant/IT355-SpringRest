package com.metropolitan.it355ispit.controller;

import com.metropolitan.it355ispit.model.Korisnik;
import com.metropolitan.it355ispit.service.KorisnikService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("/korisnici")
public class KorisnikController {

    private final KorisnikService korisnikService;

    @GetMapping("")
    public ResponseEntity<List<Korisnik>> findAll() {
        return ResponseEntity.ok(korisnikService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Korisnik> findAll(@PathVariable Long id) {
        return ResponseEntity.ok(korisnikService.findById(id));
    }

    @GetMapping("/ime")
    public ResponseEntity<List<Korisnik>> findAllByIme(@RequestParam String ime){
        return ResponseEntity.ok(korisnikService.findAllByIme(ime));
    }

    @PostMapping("")
    public ResponseEntity<Korisnik> save(@RequestBody Korisnik korisnik) {
        return ResponseEntity.status(HttpStatus.CREATED).body(korisnikService.save(korisnik));

    }

    @PutMapping("")
    public ResponseEntity<Korisnik> update(@RequestBody Korisnik korisnik) {
        return ResponseEntity.status(HttpStatus.CREATED).body(korisnikService.update(korisnik));

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        korisnikService.deleteById(id);
    }

}
