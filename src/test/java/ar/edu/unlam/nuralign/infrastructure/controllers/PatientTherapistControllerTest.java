package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.application.services.PatientTherapistService;
import ar.edu.unlam.nuralign.domain.models.PatientTherapist;
import ar.edu.unlam.nuralign.infrastructure.dtos.PatientTherapistDto;
import ar.edu.unlam.nuralign.infrastructure.mappers.PatientTherapistMapper;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PatientTherapistControllerTest {

    @Mock
    private PatientTherapistService patientTherapistService;

    @InjectMocks
    private PatientTherapistController patientTherapistController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllTherapistByPatientId() {
        Long patientId = 1L;
        List<PatientTherapist> relationships = Arrays.asList(new PatientTherapist(), new PatientTherapist());
        List<PatientTherapistDto> relationshipDtos = Arrays.asList(new PatientTherapistDto(), new PatientTherapistDto());

        try (MockedStatic<PatientTherapistMapper> mockedMapper = mockStatic(PatientTherapistMapper.class)) {
            mockedMapper.when(() -> PatientTherapistMapper.toDto(any(PatientTherapist.class))).thenReturn(new PatientTherapistDto());
            when(patientTherapistService.findAllPatientTherapistAssignations(patientId)).thenReturn(relationships);

            ResponseEntity<List<PatientTherapistDto>> response = patientTherapistController.getAllTherapistByPatientId(patientId);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(relationshipDtos.size(), response.getBody().size());
            verify(patientTherapistService, times(1)).findAllPatientTherapistAssignations(patientId);
        }
    }

    @Test
    public void testCreate() {
        PatientTherapist relationship = new PatientTherapist();
        PatientTherapistDto relationshipDto = new PatientTherapistDto();

        try (MockedStatic<PatientTherapistMapper> mockedMapper = mockStatic(PatientTherapistMapper.class)) {
            mockedMapper.when(() -> PatientTherapistMapper.toModel(relationshipDto)).thenReturn(relationship);
            mockedMapper.when(() -> PatientTherapistMapper.toDto(relationship)).thenReturn(relationshipDto);
            when(patientTherapistService.assignPatientToTherapist(any(PatientTherapist.class))).thenReturn(relationship);

            ResponseEntity<PatientTherapistDto> response = patientTherapistController.create(relationshipDto);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(relationshipDto, response.getBody());
            verify(patientTherapistService, times(1)).assignPatientToTherapist(relationship);
        }
    }

    @Test
    public void testDelete() {
        Long patientId = 1L;
        Long therapistId = 2L;
        doNothing().when(patientTherapistService).deletePatientTherapistAssignation(patientId, therapistId);

        ResponseEntity<Void> response = patientTherapistController.delete(patientId, therapistId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(patientTherapistService, times(1)).deletePatientTherapistAssignation(patientId, therapistId);
    }
}