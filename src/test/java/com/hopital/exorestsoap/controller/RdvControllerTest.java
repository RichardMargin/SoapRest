package com.hopital.exorestsoap.controller;

import com.hopital.exorestsoap.controllers.RdvController;
import com.hopital.exorestsoap.models.Medecin;
import com.hopital.exorestsoap.models.Patient;
import com.hopital.exorestsoap.models.Rdv;
import com.hopital.exorestsoap.services.RdvService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class RdvControllerTest {

@InjectMocks
private RdvController rdvController = new RdvController();
@Mock
private RdvService rdvService;

@Test
public void getAllRdvTest() throws Exception{
//Given
    List<Rdv> rdvList = new ArrayList<>();
    Rdv rdvMock1 = new Rdv();
    Rdv rdvMock2 = new Rdv();
    rdvList.add(rdvMock1);
    rdvList.add(rdvMock2);


//When
    Mockito.when(rdvService.findAll()).thenReturn(rdvList);
    ResponseEntity<List<Rdv>> response = rdvController.findAll();

//Then
    assertEquals(2,response.getBody().size());
    assertEquals(HttpStatus.OK,response.getStatusCode());
}

@Test
public void getRdvByIdTest() throws Exception{
//Given
    Rdv rdvMock = new Rdv();
    rdvMock.setId(1L);

//When
    Mockito.when(rdvService.findById(1L)).thenReturn(Optional.of(rdvMock));
    ResponseEntity<Rdv> response = rdvController.findById(1L);

//Then
    assertEquals(1L,response.getBody().getId());
    assertEquals(HttpStatus.OK,response.getStatusCode());

}

@Test
public void saveRdv() throws Exception{
//Given
    Rdv rdvMock = new Rdv();
    Patient patientMock = new Patient();
    patientMock.setId(1L);
    Medecin medecinMock = new Medecin();
    medecinMock.setId(1L);
    rdvMock.setId(1L);
    rdvMock.setPatient(patientMock);
    rdvMock.setMedecin(medecinMock);

//When
    Mockito.when(rdvService.save(rdvMock,1L,1L)).thenReturn(rdvMock);
    ResponseEntity<Rdv> response = rdvController.save(rdvMock,1L,1L);

//Then
    assertEquals(1L,response.getBody().getId());
    assertEquals(HttpStatus.CREATED,response.getStatusCode());
}

@Test
public void deleteRdvs() throws Exception{
//Given
    Rdv rdvMock = new Rdv();
    Patient patientMock = new Patient();
    patientMock.setId(1L);
    Medecin medecinMock = new Medecin();
    medecinMock.setId(1L);
    rdvMock.setId(1L);

//When
    Mockito.when(rdvService.save(rdvMock,1L,1L)).thenReturn(rdvMock);
    rdvController.save(rdvMock,1L,1L);
    rdvController.deleteAll();
    ResponseEntity<Rdv> response = rdvController.deleteById(1L);

//Then
    assertThat(response.getBody()).isNull();}
}
