package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.application.services.PatientService;
import ar.edu.unlam.nuralign.domain.models.Patient;
import ar.edu.unlam.nuralign.infrastructure.dtos.PatientDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.NOT_FOUND;

//public class PatientControllerTest {
//    @Mock
//    private PatientService patientService;
//
//    @InjectMocks
//    private PatientController patientController;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void shouldReturnPatientWhenFound() {
//        Patient patient = new Patient();
//        when(patientService.findPatient(1L)).thenReturn(Optional.of(patient));
//
//        ResponseEntity<PatientDto> response = patientController.findPatient(1L);
//
//        assertEquals(200, response.getStatusCodeValue());
//        assertEquals(patient, response.getBody());
//    }
//
//    @Test
//    void shouldReturnNotFoundWhenPatientNotPresent() {
//        when(patientService.findPatient(1L)).thenReturn(Optional.empty());
//
//        ResponseEntity<PatientDto> response = patientController.findPatient(1L);
//
//        assertEquals(404, response.getStatusCodeValue());
//    }
//
//    @Test
//    void shouldReturnAllPatients() {
//        Patient patient = new Patient();
//        PatientDto patientDto = new PatientDto();
//        when(patientService.findAllPatients()).thenReturn(Collections.singletonList(patient));
//
//        ResponseEntity<List<PatientDto>> response = patientController.findAllPatients();
//
//        assertEquals(200, response.getStatusCodeValue());
//        assertEquals(1, Objects.requireNonNull(response.getBody()).size());
//        assertEquals(patientDto, response.getBody().get(0));
//    }
//
////    @Test
////    void shouldCreatePatient() {
////        PatientDto patientDto = new PatientDto();
////        Patient patient = new Patient();
////        when(patientService.createPatient(patient)).thenReturn(patient);
////
////        ResponseEntity<PatientDto> response = patientController.createPatient(patientDto);
////
////        assertEquals(200, response.getStatusCodeValue());
////        assertEquals(patient, response.getBody());
////    }
//
//    @Test
//    void shouldUpdatePatient() {
//        PatientDto patientDto = new PatientDto();
//        Patient patient = new Patient();
//        when(patientService.updatePatient(patient, 1L)).thenReturn(Optional.of(patient));
//
//        ResponseEntity<PatientDto> response = patientController.updatePatient(patientDto, 1L);
//
//        assertEquals(200, response.getStatusCodeValue());
//        assertEquals(patientDto, response.getBody());
//    }
//
//    @Test
//    void shouldReturnNotFoundWhenUpdatingNonExistingPatient() {
////        Patient patient = new Patient();
////        when(patientService.updatePatient(patient, 1L)).thenReturn(Optional.empty());
////
////        ResponseEntity<Patient> response = patientController.updatePatient(patient, 1L);
////
////        thenGetStatus(response, NOT_FOUND);
//    }
//
//    @Test
//    void shouldDeletePatient() {
//        when(patientService.deletePatient(1L)).thenReturn(true);
//
//        ResponseEntity<Void> response = patientController.deletePatient(1L);
//
//        assertEquals(200, response.getStatusCodeValue());
//    }
//
//    @Test
//    void shouldReturnNotFoundWhenDeletingNonExistingPatient() {
//        when(patientService.deletePatient(1L)).thenReturn(false);
//
//        ResponseEntity<Void> response = patientController.deletePatient(1L);
//
//        assertEquals(404, response.getStatusCodeValue());
//    }
//
//    private static void thenGetStatus(ResponseEntity<Patient> response, HttpStatus status) {
//        assertEquals(status, response.getStatusCodeValue());
//    }
//}
