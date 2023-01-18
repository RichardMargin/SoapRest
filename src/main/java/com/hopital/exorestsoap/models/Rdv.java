package com.hopital.exorestsoap.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Rdv implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Medecin medecin;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "consultation_id",referencedColumnName = "id")
    private Consultation consultation;
}
