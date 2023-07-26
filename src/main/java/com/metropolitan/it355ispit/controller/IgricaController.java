package com.metropolitan.it355ispit.controller;


import com.metropolitan.it355ispit.model.Igrica;
import com.metropolitan.it355ispit.service.IgricaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("/igrice")
public class IgricaController {

    private final IgricaService igricaService;



    //ZA DETE
    //------------------------------------------------------------------------
    @GetMapping("/godine")
    public ResponseEntity<List<Igrica>> findAllByGodineLessThan() {
        return ResponseEntity.ok(igricaService.findAllByGodineLessThan());
    }

    @GetMapping("/zanr")
    public ResponseEntity<List<Igrica>> findAllByZanr(@RequestParam String zanr) {
        return ResponseEntity.ok(igricaService.findAllByZanr(zanr));
    }

    @GetMapping("/datum")
    public ResponseEntity<List<Igrica>> findAllByGodinaIzdavanjaBetween(@RequestParam Integer donjaGranica, @RequestParam Integer gornjaGranica) {
        return ResponseEntity.ok(igricaService.findAllByGodinaIzdavanjaBetween(donjaGranica,gornjaGranica));
    }



    //------------------------------------------------------------------------


    //ZA RODITELJA
    //------------------------------------------------------------------------
    @GetMapping("/sve")
    public ResponseEntity<List<Igrica>> findAll() {
        return ResponseEntity.ok(igricaService.findAll());
    }

    @PostMapping("/edit")
    public ResponseEntity<Igrica> updateOpisCena( @RequestParam Integer id, @RequestParam String opis,
                                                 @RequestParam Integer godine){
        return ResponseEntity.status(HttpStatus.CREATED).body(igricaService.updateGodineOpisById(id,opis,godine));
    }


    @PostMapping("")
    public ResponseEntity<Igrica> save(@RequestBody Igrica igrica) {
        return ResponseEntity.status(HttpStatus.CREATED).body(igricaService.save(igrica));

    }

    @PutMapping("")
    public ResponseEntity<Igrica> update(@RequestBody Igrica igrica) {
        return ResponseEntity.status(HttpStatus.CREATED).body(igricaService.update(igrica));

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        igricaService.deleteById(id);
    }


}
