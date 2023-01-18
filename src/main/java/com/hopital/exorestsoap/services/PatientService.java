package com.hopital.exorestsoap.services;

import com.hopital.exorestsoap.models.Medecin;
import com.hopital.exorestsoap.models.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    List<Patient> findAll();
    Optional<Patient> findById(Long id);

    Patient save(Patient patient);

    void deleteById(Long id);

    void deleteAll();
}
