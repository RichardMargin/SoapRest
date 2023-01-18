package com.hopital.exorestsoap.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hopital.exorestsoap.controllers.PatientController;
import com.hopital.exorestsoap.models.Medecin;
import com.hopital.exorestsoap.models.Patient;
import com.hopital.exorestsoap.services.PatientService;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class PatientControllerTest {
	@InjectMocks
	private PatientController patientController;
	
	@Mock
	private PatientService patientService;
	
	@Test
	public void getPatientAll_NotEmptyTest() throws Exception{
		//Given
		List<Patient> patientList = new ArrayList<>();
		
		Patient patientMock1 = new Patient();
		Patient patientMock2 = new Patient();
		
		patientList.add(patientMock1);
		patientList.add(patientMock2);
		
		//When
		Mockito.when(patientService.findAll()).thenReturn(patientList);
		ResponseEntity<List<Patient>> response = patientController.findAll();
		
		//Then
		assertEquals(2,response.getBody().size());
		assertEquals(HttpStatus.OK,response.getStatusCode());
	}
	
	@Test
	public void getPatientAll_EmptyTest() throws Exception{
		//Given
		List<Patient> medecinList = new ArrayList<>();
	    
		//When
		Mockito.when(patientService.findAll()).thenReturn(medecinList);
		ResponseEntity<List<Patient>> response = patientController.findAll();
		
		//Then
		assertEquals(null,response.getBody());
		assertEquals(HttpStatus.NO_CONTENT,response.getStatusCode());
	}
	
	
	@Test
	public void findPatientById_NotEmpty_Test() throws Exception{
		//Given
		Patient patientMock = new Patient();
		patientMock.setId(1L);
		patientMock.setNom("Dupont");
		patientMock.setPrenom("Jean-Christophe");
		patientMock.setRdvs(null);
		
		Optional<Patient> optionalMock = Optional.of(patientMock);
		
		//When
		Mockito.when(patientService.findById(Mockito.any())).thenReturn(optionalMock);
		ResponseEntity<Patient> response = patientController.findById(1L);
		
		//Then
		assertThat(response.getBody().getId()).isEqualTo(1L);
		assertThat(response.getBody().getPrenom()).isEqualTo("Jean-Christophe");
		assertThat(response.getBody().getNom()).isEqualTo("Dupont");
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	
	@Test
	public void findPatientById_Empty_Test() throws Exception{
		//Given

		
		//When
		Mockito.when(patientService.findById(Mockito.any())).thenReturn(Optional.empty());
		ResponseEntity<Patient> response = patientController.findById(1L);
		
		//Then
		assertThat(response.getBody()).isEqualTo(null);
		assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}

}
