package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.patient.*;
import ar.edu.unlam.nuralign.domain.models.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PatientServiceTest {
    @Mock
    private CreatePatientUseCase createPatientUseCase;

    @Mock
    private FindPatientUseCase findPatientUseCase;

    @Mock
    private FindAllPatientsUseCase findAllPatientsUseCase;

    @Mock
    private DeletePatientUseCase deletePatientUseCase;

    @Mock
    private UpdatePatientUseCase updatePatientUseCase;

    @InjectMocks
    private PatientService patientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testThatShouldCreatePatient() {
        Patient patient = new Patient();
        when(createPatientUseCase.createPatient(patient)).thenReturn(patient);

        Patient result = patientService.createPatient(patient);

        assertEquals(patient, result);
        verify(createPatientUseCase, times(1)).createPatient(patient);
    }

    @Test
    void testThatShouldFindPatient() {
        Patient patient = new Patient();
        when(findPatientUseCase.findPatient(1L)).thenReturn(Optional.of(patient));

        Optional<Patient> result = patientService.findPatient(1L);

        assertEquals(Optional.of(patient), result);
        verify(findPatientUseCase, times(1)).findPatient(1L);
    }

    @Test
    void testThatShouldFindAllPatients() {
        Patient patient = new Patient();
        when(findAllPatientsUseCase.findAllPatients()).thenReturn(Collections.singletonList(patient));

        List<Patient> result = patientService.findAllPatients();

        assertEquals(Collections.singletonList(patient), result);
        verify(findAllPatientsUseCase, times(1)).findAllPatients();
    }

    @Test
    void testThatShouldUpdatePatient() {
        Patient patient = new Patient();
        when(updatePatientUseCase.updatePatient(patient, 1L)).thenReturn(Optional.of(patient));

        Optional<Patient> result = patientService.updatePatient(patient, 1L);

        assertEquals(Optional.of(patient), result);
        verify(updatePatientUseCase, times(1)).updatePatient(patient, 1L);
    }

    @Test
    void testThatShouldDeletePatient() {
        when(deletePatientUseCase.deletePatient(1L)).thenReturn(true);

        boolean result = patientService.deletePatient(1L);

        assertEquals(true, result);
        verify(deletePatientUseCase, times(1)).deletePatient(1L);
    }
}
