package com.hopital.exorestsoap.services;

import com.hopital.exorestsoap.models.Medecin;

import java.util.List;
import java.util.Optional;

public interface MedecinService {
    List<Medecin> findAll();
    Optional<Medecin> findById(Long id);

    Medecin save(Medecin medecin);

    void deleteById(Long id);

    void deleteAll();
}
