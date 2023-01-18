package com.hopital.exorestsoap.controllers;

import com.hopital.exorestsoap.models.Medecin;
import com.hopital.exorestsoap.models.Patient;
import com.hopital.exorestsoap.models.Rdv;
import com.hopital.exorestsoap.services.MedecinService;
import com.hopital.exorestsoap.services.PatientService;
import com.hopital.exorestsoap.services.RdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hopital-api/rdvs")
public class RdvController {

    @Autowired
    private RdvService rdvService;

    @Autowired
    private MedecinService medecinService;

    @Autowired
    private PatientService patientService;

    @GetMapping("/all")
    public ResponseEntity<List<Rdv>> findAll() {
        List<Rdv> rdvs = rdvService.findAll();
        if (rdvs != null && !rdvs.isEmpty()) {
            return new ResponseEntity<>(rdvs, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rdv> findById(@PathVariable Long id) {
        Optional<Rdv> rdv = rdvService.findById(id);
        if (rdv.isPresent()) {
            return new ResponseEntity<>(rdv.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/new/{idPatient}/{idMedecin}")
    public ResponseEntity<Rdv> save(@RequestBody Rdv rdv, @PathVariable Long idPatient, @PathVariable Long idMedecin) {
        Rdv rd = rdvService.save(rdv, idPatient, idMedecin);
        if (rd != null) {
            return new ResponseEntity<>(rd, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/edit/{idPatient}/{idMedecin}")
    public ResponseEntity<Rdv> update(@RequestBody Rdv rdv, @PathVariable Long idPatient, @PathVariable Long idMedecin) {
        Rdv rd = rdvService.save(rdv, idPatient, idMedecin);
        if (rd != null) {
            return new ResponseEntity<>(rd, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Rdv> deleteById(@PathVariable Long id) {
        rdvService.deleteById(id);
        Optional<Rdv> rdv = rdvService.findById(id);
        if (!rdv.isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<Rdv> deleteAll() {
        rdvService.deleteAll();
        List<Rdv> rdvs = rdvService.findAll();
        if (rdvs == null || rdvs.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
