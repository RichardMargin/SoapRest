package com.hopital.exorestsoap.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hopital.exorestsoap.controllers.PatientController;
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

}
