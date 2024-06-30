package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.application.services.MedicationsService;
import ar.edu.unlam.nuralign.domain.models.Medication;
import ar.edu.unlam.nuralign.infrastructure.dtos.MedicationDto;
import ar.edu.unlam.nuralign.infrastructure.mappers.MedicationMapper;
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

public class MedicationControllerTest {

    @Mock
    private MedicationsService medicationService;

    @InjectMocks
    private MedicationController medicationController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindMedication() {
        Long medicationId = 1L;
        Medication medication = new Medication();
        MedicationDto medicationDto = MedicationDto.builder().build();

        try (MockedStatic<MedicationMapper> mockedMapper = mockStatic(MedicationMapper.class)) {
            mockedMapper.when(() -> MedicationMapper.toDto(medication)).thenReturn(medicationDto);
            when(medicationService.findMedication(medicationId)).thenReturn(medication);

            ResponseEntity<MedicationDto> response = medicationController.findMedication(medicationId);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(medicationDto, response.getBody());
            verify(medicationService, times(1)).findMedication(medicationId);
        }
    }

    @Test
    public void testFindMedicationsByPatientId() {
        Long patientId = 1L;
        List<Medication> medications = Arrays.asList(new Medication(), new Medication());
        List<MedicationDto> medicationDtos = Arrays.asList(MedicationDto.builder().build(), MedicationDto.builder().build());

        try (MockedStatic<MedicationMapper> mockedMapper = mockStatic(MedicationMapper.class)) {
            mockedMapper.when(() -> MedicationMapper.toDto(any(Medication.class))).thenReturn(MedicationDto.builder().build());
            when(medicationService.findMedicationsByPatientId(patientId)).thenReturn(medications);

            ResponseEntity<List<MedicationDto>> response = medicationController.findMedicationsByPatientId(patientId);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(medicationDtos.size(), response.getBody().size());
            verify(medicationService, times(1)).findMedicationsByPatientId(patientId);
        }
    }

    @Test
    public void testFindAllMedications() {
        List<Medication> medications = Arrays.asList(new Medication(), new Medication());
        List<MedicationDto> medicationDtos = Arrays.asList(MedicationDto.builder().build(), MedicationDto.builder().build());

        try (MockedStatic<MedicationMapper> mockedMapper = mockStatic(MedicationMapper.class)) {
            mockedMapper.when(() -> MedicationMapper.toDto(any(Medication.class))).thenReturn(MedicationDto.builder().build());
            when(medicationService.findAllMedications()).thenReturn(medications);

            ResponseEntity<List<MedicationDto>> response = medicationController.findAllMedications();

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(medicationDtos.size(), response.getBody().size());
            verify(medicationService, times(1)).findAllMedications();
        }
    }

    @Test
    public void testCreateMedication() {
        Medication medication = new Medication();
        MedicationDto medicationDto = MedicationDto.builder().build();

        try (MockedStatic<MedicationMapper> mockedMapper = mockStatic(MedicationMapper.class)) {
            mockedMapper.when(() -> MedicationMapper.toModel(medicationDto)).thenReturn(medication);
            mockedMapper.when(() -> MedicationMapper.toDto(medication)).thenReturn(medicationDto);
            when(medicationService.createMedication(any(Medication.class))).thenReturn(medication);

            ResponseEntity<MedicationDto> response = medicationController.createMedication(medication);

            assertEquals(HttpStatus.CREATED, response.getStatusCode());
            assertEquals(medicationDto, response.getBody());
            verify(medicationService, times(1)).createMedication(medication);
        }
    }

    @Test
    public void testUpdateMedication() {
        Long patientId = 1L;
        Medication medication = new Medication();
        MedicationDto medicationDto = MedicationDto.builder().build();

        try (MockedStatic<MedicationMapper> mockedMapper = mockStatic(MedicationMapper.class)) {
            mockedMapper.when(() -> MedicationMapper.toModel(medicationDto)).thenReturn(medication);
            mockedMapper.when(() -> MedicationMapper.toDto(medication)).thenReturn(medicationDto);
            when(medicationService.updateMedication(any(Medication.class), eq(patientId))).thenReturn(Optional.of(medication));

            ResponseEntity<MedicationDto> response = medicationController.updateMedication(medicationDto, patientId);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(medicationDto, response.getBody());
            verify(medicationService, times(1)).updateMedication(medication, patientId);
        }
    }

    @Test
    public void testDeleteMedication() {
        Long medicationId = 1L;
        doNothing().when(medicationService).deleteMedication(medicationId);

        ResponseEntity<Void> response = medicationController.deleteMedication(medicationId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(medicationService, times(1)).deleteMedication(medicationId);
    }
}