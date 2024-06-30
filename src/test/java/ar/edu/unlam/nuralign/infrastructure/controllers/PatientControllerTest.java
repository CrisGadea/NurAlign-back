package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.application.services.PatientService;
import ar.edu.unlam.nuralign.domain.models.Patient;
import ar.edu.unlam.nuralign.infrastructure.dtos.PatientDto;
import ar.edu.unlam.nuralign.infrastructure.mappers.PatientMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PatientControllerTest {

    @Mock
    private PatientService patientService;

    @InjectMocks
    private PatientController patientController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindPatient() {
        Long patientId = 1L;
        Patient patient = new Patient();
        PatientDto patientDto = new PatientDto();

        try (MockedStatic<PatientMapper> mockedMapper = mockStatic(PatientMapper.class)) {
            mockedMapper.when(() -> PatientMapper.mapToDto(patient)).thenReturn(patientDto);
            when(patientService.findPatient(patientId)).thenReturn(Optional.of(patient));

            ResponseEntity<PatientDto> response = patientController.findPatient(patientId);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(patientDto, response.getBody());
            verify(patientService, times(1)).findPatient(patientId);
        }
    }

    @Test
    public void testFindAllPatients() {
        List<Patient> patients = Arrays.asList(new Patient(), new Patient());
        List<PatientDto> patientDtos = Arrays.asList(new PatientDto(), new PatientDto());

        try (MockedStatic<PatientMapper> mockedMapper = mockStatic(PatientMapper.class)) {
            mockedMapper.when(() -> PatientMapper.mapToDto(any(Patient.class))).thenReturn(new PatientDto());
            when(patientService.findAllPatients()).thenReturn(patients);

            ResponseEntity<List<PatientDto>> response = patientController.findAllPatients();

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(patientDtos.size(), response.getBody().size());
            verify(patientService, times(1)).findAllPatients();
        }
    }

    @Test
    public void testCreatePatient() {
        Patient patient = new Patient();
        PatientDto patientDto = new PatientDto();

        try (MockedStatic<PatientMapper> mockedMapper = mockStatic(PatientMapper.class)) {
            mockedMapper.when(() -> PatientMapper.mapToDomain(patientDto)).thenReturn(patient);
            mockedMapper.when(() -> PatientMapper.mapToDto(patient)).thenReturn(patientDto);
            when(patientService.createPatient(any(Patient.class))).thenReturn(patient);

            ResponseEntity<PatientDto> response = patientController.createPatient(patientDto);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(patientDto, response.getBody());
            verify(patientService, times(1)).createPatient(patient);
        }
    }

    @Test
    public void testUpdatePatient() {
        Long patientId = 1L;
        Patient patient = new Patient();
        PatientDto patientDto = new PatientDto();

        try (MockedStatic<PatientMapper> mockedMapper = mockStatic(PatientMapper.class)) {
            mockedMapper.when(() -> PatientMapper.mapToDomain(patientDto)).thenReturn(patient);
            mockedMapper.when(() -> PatientMapper.mapToDto(patient)).thenReturn(patientDto);
            when(patientService.updatePatient(any(Patient.class), eq(patientId))).thenReturn(Optional.of(patient));

            ResponseEntity<PatientDto> response = patientController.updatePatient(patientDto, patientId);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(patientDto, response.getBody());
            verify(patientService, times(1)).updatePatient(patient, patientId);
        }
    }

    @Test
    public void testDeletePatient() {
        Long patientId = 1L;
        when(patientService.deletePatient(patientId)).thenReturn(true);

        ResponseEntity<Void> response = patientController.deletePatient(patientId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(patientService, times(1)).deletePatient(patientId);
    }
}