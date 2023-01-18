package com.hopital.exorestsoap.controllers;

import com.hopital.exorestsoap.models.Patient;
import com.hopital.exorestsoap.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hopital-api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/all")
    public ResponseEntity<List<Patient>> findAll() {
        List<Patient> patients = patientService.findAll();
        if (patients != null && !patients.isEmpty()) {
            return new ResponseEntity<>(patients, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findById(@PathVariable Long id) {
        Optional<Patient> patient = patientService.findById(id);
        if (patient.isPresent()) {
            return new ResponseEntity<>(patient.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/new")
    public ResponseEntity<Patient> save(@RequestBody Patient patient) {
        Patient pat = patientService.save(patient);
        if (pat != null) {
            return new ResponseEntity<>(pat, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/edit")
    public ResponseEntity<Patient> update(@RequestBody Patient patient) {
        Patient pat = patientService.save(patient);
        if (pat != null) {
            return new ResponseEntity<>(pat, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Patient> deleteById(@PathVariable Long id) {
        patientService.deleteById(id);
        Optional<Patient> patient = patientService.findById(id);
        if (!patient.isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<Patient> deleteAll() {
        patientService.deleteAll();
        List<Patient> patients = patientService.findAll();
        if (patients == null || patients.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
