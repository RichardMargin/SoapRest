package com.hopital.exorestsoap.repositories;

import com.hopital.exorestsoap.models.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
}
