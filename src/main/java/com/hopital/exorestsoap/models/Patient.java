package com.hopital.exorestsoap.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Patient implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private Date dateDeNaissance;
    private String telephone;
    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private List<Rdv> rdvs;


}
