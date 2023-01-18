package com.hopital.exorestsoap.controller;

import com.hopital.exorestsoap.controllers.ConsultationController;
import com.hopital.exorestsoap.controllers.RdvController;
import com.hopital.exorestsoap.models.Consultation;
import com.hopital.exorestsoap.models.Medecin;
import com.hopital.exorestsoap.models.Patient;
import com.hopital.exorestsoap.models.Rdv;
import com.hopital.exorestsoap.services.ConsultationService;
import com.hopital.exorestsoap.services.RdvService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)


public class ConsultationControllerTest {
    @InjectMocks
    private ConsultationController consultationController = new ConsultationController();
    @Mock
    private ConsultationService coonsultationService;

    @Test
    public void getAllConsultationTest() throws Exception{
        //Given
        List<Consultation> consultationList = new ArrayList<>();
        Consultation consultation1 = new Consultation();
        Consultation consultation2 = new Consultation();
        consultationList.add(consultation1);
        consultationList.add(consultation2);
        //When
        Mockito.when(coonsultationService.findAll()).thenReturn(consultationList);
        //Then
        assertEquals(2,consultationController.findAll().getBody().size());

    }

    @Test
    public void getConsultationByIdTest() throws Exception {
        //Given
        Consultation consultation = new Consultation();
        consultation.setId(1L);
        //When
        Mockito.when(coonsultationService.findById(1L)).thenReturn(java.util.Optional.of(consultation));
        //Then
        assertEquals(1L, consultationController.findById(1L).getBody().getId());
    }

    @Test
    public void deleteConsultationTest() throws Exception {

        //Given
        Consultation consultation = new Consultation();
//When
        Mockito.when(coonsultationService.save(consultation)).thenReturn(consultation);
        coonsultationService.save(consultation);
        coonsultationService.deleteAll();
        ResponseEntity<Consultation> response = consultationController.findById(1L);
//Then
        assertThat(response.getBody()).isNull();
    }


    @Test

    public void createConsultationTest() throws Exception {
        //Given
        Consultation consultation = new Consultation();
        consultation.setId(1L);
        //When
        Mockito.when(coonsultationService.save(consultation)).thenReturn(consultation);
        //Then
        assertEquals(1L, coonsultationService.save(consultation).getId());
    }
}
