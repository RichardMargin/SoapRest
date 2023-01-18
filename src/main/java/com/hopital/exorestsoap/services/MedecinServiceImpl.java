package com.hopital.exorestsoap.services;

import com.hopital.exorestsoap.models.Medecin;
import com.hopital.exorestsoap.repositories.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedecinServiceImpl implements MedecinService {

    @Autowired
    private MedecinRepository medecinRepository;

    @Override
    public List<Medecin> findAll() {
        return medecinRepository.findAll();
    }

    @Override
    public Optional<Medecin> findById(Long id) {
        return medecinRepository.findById(id);
    }

    @Override
    public Medecin save(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public void deleteById(Long id) {
        medecinRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        medecinRepository.deleteAll();
    }
}
