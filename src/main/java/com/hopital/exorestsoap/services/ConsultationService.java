package com.hopital.exorestsoap.services;

import com.hopital.exorestsoap.models.Consultation;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface ConsultationService {
    List<Consultation> findAll();
    Optional<Consultation> findById(Long id);

    Consultation save(Consultation consultation);

    void deleteById(Long id);

    void deleteAll();
}
