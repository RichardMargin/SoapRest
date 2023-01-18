package com.hopital.exorestsoap.services;

import com.hopital.exorestsoap.models.Consultation;
import com.hopital.exorestsoap.models.Medecin;
import com.hopital.exorestsoap.models.Patient;
import com.hopital.exorestsoap.models.Rdv;
import com.hopital.exorestsoap.repositories.ConsultationRepository;
import com.hopital.exorestsoap.repositories.RdvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RdvServiceImpl implements RdvService {

    @Autowired
    private RdvRepository rdvRepository;

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private PatientService patientService;

    @Autowired
    private MedecinService medecinService;

    @Override
    public List<Rdv> findAll() {
        return rdvRepository.findAll();
    }

    @Override
    public Optional<Rdv> findById(Long id) {
        return rdvRepository.findById(id);
    }

    @Override
    public Rdv save(Rdv rdv, Long idPatient, Long idMedecin) {
        Optional<Patient> patient = patientService.findById(idPatient);
        Optional<Medecin> medecin = medecinService.findById(idMedecin);
        if (medecin.isPresent() && patient.isPresent()) {
            rdv.setPatient(patient.get());
            rdv.setMedecin(medecin.get());
        }
        if (rdv.getId()==null) {
            Consultation consultation = consultationRepository.save(new Consultation());
            rdv.setConsultation(consultation);
        }
        return rdvRepository.save(rdv);
    }

    @Override
    public void deleteById(Long id) {
        rdvRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        rdvRepository.deleteAll();
    }
}
