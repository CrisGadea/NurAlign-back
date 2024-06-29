package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.patientTherapist.AssignPatientToTherapistUseCase;
import ar.edu.unlam.nuralign.application.ports.in.patientTherapist.DeletePatientTherapistAssignationUseCase;
import ar.edu.unlam.nuralign.application.ports.in.patientTherapist.FindAllPatientTherapistAssignationsUseCase;
import ar.edu.unlam.nuralign.domain.models.PatientTherapist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PatientTherapistServiceTest {
    @Mock
    private AssignPatientToTherapistUseCase assignPatientToTherapistUseCase;

    @Mock
    private FindAllPatientTherapistAssignationsUseCase findAllPatientTherapistAssignationsUseCase;

    @Mock
    private DeletePatientTherapistAssignationUseCase deletePatientTherapistAssignationUseCase;

    @InjectMocks
    private PatientTherapistService patientTherapistService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Should assign patient to therapist")
    @Test
    void shouldAssignPatientToTherapist() {
        PatientTherapist patientTherapist = new PatientTherapist();
        when(assignPatientToTherapistUseCase.assignPatientToTherapist(patientTherapist)).thenReturn(patientTherapist);

        PatientTherapist result = patientTherapistService.assignPatientToTherapist(patientTherapist);

        verify(assignPatientToTherapistUseCase, times(1)).assignPatientToTherapist(patientTherapist);
        assertEquals(patientTherapist, result);
    }

    @DisplayName("Should find all patient therapist assignations")
    @Test
    void shouldFindAllPatientTherapistAssignations() {
        Long patientId = 1L;
        List<PatientTherapist> patientTherapists = Collections.singletonList(new PatientTherapist());
        when(findAllPatientTherapistAssignationsUseCase.findAllPatientTherapistAssignations(patientId)).thenReturn(patientTherapists);

        List<PatientTherapist> result = patientTherapistService.findAllPatientTherapistAssignations(patientId);

        verify(findAllPatientTherapistAssignationsUseCase, times(1)).findAllPatientTherapistAssignations(patientId);
        assertEquals(patientTherapists, result);
    }

    @DisplayName("Should delete patient therapist assignation")
    @Test
    void shouldDeletePatientTherapistAssignation() {
        Long patientId = 1L;
        Long therapistId = 1L;
        doNothing().when(deletePatientTherapistAssignationUseCase).deletePatientTherapistAssignation(patientId, therapistId);

        patientTherapistService.deletePatientTherapistAssignation(patientId, therapistId);

        verify(deletePatientTherapistAssignationUseCase, times(1)).deletePatientTherapistAssignation(patientId, therapistId);

    }
    }
