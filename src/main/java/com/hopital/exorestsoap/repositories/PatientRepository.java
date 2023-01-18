package com.hopital.exorestsoap.repositories;

import com.hopital.exorestsoap.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
