package com.hopital.exorestsoap.repositories;

import com.hopital.exorestsoap.models.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
