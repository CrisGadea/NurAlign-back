package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.medication.*;
import ar.edu.unlam.nuralign.domain.models.Medication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doNothing;

public class MedicationsServiceTest {
    @Mock
    private CreateMedicationUseCase createMedicationUseCase;
    @Mock
    private FindMedicationUseCase findMedicationUseCase;
    @Mock
    private FindAllMedicationsUseCase findAllMedicationsUseCase;
    @Mock
    private FindMedicationsByPatientIdUseCase findMedicationsByPatientIdUseCase;
    @Mock
    private UpdateMedicationUseCase updateMedicationUseCase;
    @Mock
    private DeleteMedicationUseCase deleteMedicationUseCase;

    @InjectMocks
    private MedicationsService medicationsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Should create medication")
    @Test
    void shouldCreateMedication() {
        Medication medication = new Medication();
        when(createMedicationUseCase.createMedication(any(Medication.class))).thenReturn(medication);

        Medication result = medicationsService.createMedication(medication);

        verify(createMedicationUseCase, times(1)).createMedication(any(Medication.class));
        assertNotNull(result);
    }

    @DisplayName("Should find medication by id")
    @Test
    void shouldFindMedication() {
        Long id = 1L;
        Medication medication = new Medication();
        when(findMedicationUseCase.findMedication(id)).thenReturn(medication);

        Medication result = medicationsService.findMedication(id);

        verify(findMedicationUseCase, times(1)).findMedication(id);
        assertNotNull(result);
    }

    @DisplayName("Should find all medications")
    @Test
    void shouldFindAllMedications() {
        Medication medication = new Medication();
        when(findAllMedicationsUseCase.findAllMedications()).thenReturn(Collections.singletonList(medication));

        var result = medicationsService.findAllMedications();

        verify(findAllMedicationsUseCase, times(1)).findAllMedications();
        assertEquals(1, result.size());
    }

    @DisplayName("Should find medications by patient id")
    @Test
    void shouldFindMedicationsByPatientId() {
        Long patientId = 1L;
        Medication medication = new Medication();
        when(findMedicationsByPatientIdUseCase.findMedicationsByPatientId(patientId)).thenReturn(Collections.singletonList(medication));

        var result = medicationsService.findMedicationsByPatientId(patientId);

        verify(findMedicationsByPatientIdUseCase, times(1)).findMedicationsByPatientId(patientId);
        assertEquals(1, result.size());
    }

    @DisplayName("Should update medication")
    @Test
    void shouldUpdateMedication() {
        Long patientId = 1L;
        Medication medication = new Medication();
        when(updateMedicationUseCase.updateMedication(any(Medication.class), eq(patientId))).thenReturn(Optional.of(medication));

        Optional<Medication> result = medicationsService.updateMedication(medication, patientId);

        verify(updateMedicationUseCase, times(1)).updateMedication(any(Medication.class), eq(patientId));
        assertNotNull(result);
    }

    @DisplayName("Should delete medication")
    @Test
    void shouldDeleteMedication() {
        Long medicationId = 1L;
        doNothing().when(deleteMedicationUseCase).deleteMedication(medicationId);

        medicationsService.deleteMedication(medicationId);

        verify(deleteMedicationUseCase, times(1)).deleteMedication(medicationId);
    }
}