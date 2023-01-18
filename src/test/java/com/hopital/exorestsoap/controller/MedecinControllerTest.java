package com.hopital.exorestsoap.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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
	
	@Test
	public void findMedecinById_NotEmpty_Test() throws Exception{
		//Given
		Medecin medecinMock = new Medecin();
		medecinMock.setId(1L);
		medecinMock.setNom("Dupont");
		medecinMock.setPrenom("Jean-Christophe");
		medecinMock.setRdvs(null);
		
		Optional<Medecin> optionalMock = Optional.of(medecinMock);
		
		//When
		Mockito.when(medecinService.findById(Mockito.any())).thenReturn(optionalMock);
		ResponseEntity<Medecin> response = medecinController.findById(1L);
		
		//Then
		assertThat(response.getBody().getId()).isEqualTo(1L);
		assertThat(response.getBody().getPrenom()).isEqualTo("Jean-Christophe");
		assertThat(response.getBody().getNom()).isEqualTo("Dupont");
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	
	@Test
	public void findMedecinById_Empty_Test() throws Exception{
		//Given

		
		//When
		Mockito.when(medecinService.findById(Mockito.any())).thenReturn(Optional.empty());
		ResponseEntity<Medecin> response = medecinController.findById(1L);
		
		//Then
		assertThat(response.getBody()).isEqualTo(null);
		assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}

}
