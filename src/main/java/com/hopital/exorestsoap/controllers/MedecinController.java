package com.hopital.exorestsoap.controllers;

import com.hopital.exorestsoap.models.Medecin;
import com.hopital.exorestsoap.services.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hopital-api/medecins")
public class MedecinController {

    @Autowired
    private MedecinService medecinService;

    @GetMapping("/all")
    public ResponseEntity<List<Medecin>> findAll() {
        List<Medecin> medecins = medecinService.findAll();
        if (medecins != null && !medecins.isEmpty()) {
            return new ResponseEntity<>(medecins, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medecin> findById(@PathVariable Long id) {
        Optional<Medecin> medecin = medecinService.findById(id);
        if (medecin.isPresent()) {
            return new ResponseEntity<>(medecin.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/new")
    public ResponseEntity<Medecin> save(@RequestBody Medecin medecin) {
        Medecin med = medecinService.save(medecin);
        if (med != null) {
            return new ResponseEntity<>(med, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/edit")
    public ResponseEntity<Medecin> update(@RequestBody Medecin medecin) {
        Medecin med = medecinService.save(medecin);
        if (med != null) {
            return new ResponseEntity<>(med, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Medecin> deleteById(@PathVariable Long id) {
        medecinService.deleteById(id);
        Optional<Medecin> medecin = medecinService.findById(id);
        if (!medecin.isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<Medecin> deleteAll() {
        medecinService.deleteAll();
        List<Medecin> medecins = medecinService.findAll();
        if (medecins == null || medecins.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
