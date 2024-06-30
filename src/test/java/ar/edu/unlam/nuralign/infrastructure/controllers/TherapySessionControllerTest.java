package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.application.services.TherapySessionService;
import ar.edu.unlam.nuralign.domain.models.TherapySession;
import ar.edu.unlam.nuralign.infrastructure.dtos.TherapySessionDto;
import ar.edu.unlam.nuralign.infrastructure.mappers.TherapySessionMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class TherapySessionControllerTest {

    @Mock
    private TherapySessionService therapySessionService;

    @InjectMocks
    private TherapySessionController therapySessionController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateTherapySession() {
        TherapySessionDto therapySessionDto = TherapySessionDto.builder().build();
        TherapySession therapySession = new TherapySession();

        try (MockedStatic<TherapySessionMapper> mockedMapper = mockStatic(TherapySessionMapper.class)) {
            mockedMapper.when(() -> TherapySessionMapper.toModel(therapySessionDto)).thenReturn(therapySession);
            mockedMapper.when(() -> TherapySessionMapper.toDto(therapySession)).thenReturn(therapySessionDto);
            when(therapySessionService.createTherapySession(any(TherapySession.class))).thenReturn(therapySession);

            ResponseEntity<TherapySessionDto> response = therapySessionController.createTherapySession(therapySessionDto);

            assertEquals(HttpStatus.CREATED, response.getStatusCode());
            assertEquals(therapySessionDto, response.getBody());
            verify(therapySessionService, times(1)).createTherapySession(therapySession);
        }
    }

    @Test
    public void testGetTherapySessionById() {
        Long id = 1L;
        TherapySession therapySession = new TherapySession();
        TherapySessionDto therapySessionDto = TherapySessionDto.builder().build();

        try (MockedStatic<TherapySessionMapper> mockedMapper = mockStatic(TherapySessionMapper.class)) {
            mockedMapper.when(() -> TherapySessionMapper.toDto(therapySession)).thenReturn(therapySessionDto);
            when(therapySessionService.FindTherapySessionById(id)).thenReturn(therapySession);

            ResponseEntity<TherapySessionDto> response = therapySessionController.getTherapySessionById(id);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(therapySessionDto, response.getBody());
            verify(therapySessionService, times(1)).FindTherapySessionById(id);
        }
    }

    @Test
    public void testGetAllTherapySessionByPatientId() {
        Long patientId = 1L;
        List<TherapySession> therapySessions = Arrays.asList(new TherapySession(), new TherapySession());
        List<TherapySessionDto> therapySessionDtos = Arrays.asList(TherapySessionDto.builder().build(), TherapySessionDto.builder().build());

        try (MockedStatic<TherapySessionMapper> mockedMapper = mockStatic(TherapySessionMapper.class)) {
            mockedMapper.when(() -> TherapySessionMapper.toDto(any(TherapySession.class))).thenReturn(TherapySessionDto.builder().build());
            when(therapySessionService.FindAllTherapySessionByPatientId(patientId)).thenReturn(therapySessions);

            ResponseEntity<List<TherapySession>> response = therapySessionController.getAllTherapySessionByPatientId(patientId);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(therapySessionDtos.size(), response.getBody().size());
            verify(therapySessionService, times(1)).FindAllTherapySessionByPatientId(patientId);
        }
    }

    @Test
    public void testGetAllTherapySessionByTherapistId() {
        Long therapistId = 1L;
        List<TherapySession> therapySessions = Arrays.asList(new TherapySession(), new TherapySession());

        when(therapySessionService.FindAllTherapySessionByTherapistId(therapistId)).thenReturn(therapySessions);

        ResponseEntity<List<TherapySession>> response = therapySessionController.getAllTherapySessionByTherapistId(therapistId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(therapySessions, response.getBody());
        verify(therapySessionService, times(1)).FindAllTherapySessionByTherapistId(therapistId);
    }

    @Test
    public void testGetAllTherapySessionByPatientIdAndTherapistId() {
        Long patientId = 1L;
        Long therapistId = 2L;
        List<TherapySession> therapySessions = Arrays.asList(new TherapySession(), new TherapySession());

        when(therapySessionService.findAllTherapySessionsByPatientIdAndTherapistId(patientId, therapistId)).thenReturn(therapySessions);

        ResponseEntity<List<TherapySession>> response = therapySessionController.getAllTherapySessionByPatientIdAndTherapistId(patientId, therapistId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(therapySessions, response.getBody());
        verify(therapySessionService, times(1)).findAllTherapySessionsByPatientIdAndTherapistId(patientId, therapistId);
    }

    @Test
    public void testUpdateTherapySession() {
        Long patientId = 1L;
        Long therapistId = 2L;
        String effectiveDate = "2023-01-01";
        TherapySession therapySession = new TherapySession();
        TherapySessionDto therapySessionDto = TherapySessionDto.builder().build();

        try (MockedStatic<TherapySessionMapper> mockedMapper = mockStatic(TherapySessionMapper.class)) {
            mockedMapper.when(() -> TherapySessionMapper.toModel(therapySessionDto)).thenReturn(therapySession);
            mockedMapper.when(() -> TherapySessionMapper.toDto(therapySession)).thenReturn(therapySessionDto);
            when(therapySessionService.update(any(TherapySession.class), eq(patientId))).thenReturn(therapySession);

            ResponseEntity<TherapySessionDto> response = therapySessionController.updateTherapySession(patientId, therapySessionDto);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(therapySessionDto, response.getBody());
            verify(therapySessionService, times(1)).update(therapySession, patientId);
        }
    }
}