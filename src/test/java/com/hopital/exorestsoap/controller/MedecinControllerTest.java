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

import com.hopital.exorestsoap.controllers.MedecinController;
import com.hopital.exorestsoap.models.Medecin;
import com.hopital.exorestsoap.services.MedecinService;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class MedecinControllerTest {
	
	@InjectMocks
	private MedecinController medecinController;
	
	@Mock
	private MedecinService medecinService;
	
	@Test
	public void getMedecinAll_NotEmptyTest() throws Exception{
		//Given
		List<Medecin> medecinList = new ArrayList<>();
		
		Medecin medecinMock1 = new Medecin();
		Medecin medecinMock2 = new Medecin();
		
		medecinList.add(medecinMock1);
		medecinList.add(medecinMock2);
		
		//When
		Mockito.when(medecinService.findAll()).thenReturn(medecinList);
		ResponseEntity<List<Medecin>> response = medecinController.findAll();
		
		//Then
		assertEquals(2,response.getBody().size());
		assertEquals(HttpStatus.OK,response.getStatusCode());
	}
	
	@Test
	public void getMedecinAll_EmptyTest() throws Exception{
		//Given
		List<Medecin> medecinList = new ArrayList<>();
	    
		//When
		Mockito.when(medecinService.findAll()).thenReturn(medecinList);
		ResponseEntity<List<Medecin>> response = medecinController.findAll();
		
		//Then
		assertEquals(null,response.getBody());
		assertEquals(HttpStatus.NO_CONTENT,response.getStatusCode());
	}

}
