package com.hopital.exorestsoap.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Consultation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String diagnostique;
    private String traitement;

    @OneToOne(mappedBy = "consultation", cascade = CascadeType.ALL)
    @JsonIgnore
    private Rdv rdv;
}
