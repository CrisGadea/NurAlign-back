package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.therapySession.*;
import ar.edu.unlam.nuralign.domain.models.TherapySession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TherapySessionServiceTest {

    @Mock
    private CreateTherapySessionUseCase createTherapySessionUseCase;

    @Mock
    private FindTherapySessionByIdUseCase findTherapySessionByIdUseCase;

    @Mock
    private FindAllTherapySessionByPatientIdUseCase findTherapySessionByPatientIdUseCase;

    @Mock
    private FindAllTherapySessionByTherapistIdUseCase findTherapySessionByTherapistIdUseCase;

    @Mock
    private UpdateTherapistSessionUseCase updateTherapistSessionUseCase;

    @Mock
    private FindAllTherapySessionsByPatientIdAndTherapistIdUseCase findAllTherapySessionsByPatientIdAndTherapistIdUseCase;

    @InjectMocks
    private TherapySessionService therapySessionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateTherapySession() {
        TherapySession therapySession = new TherapySession();
        when(createTherapySessionUseCase.createTherapySession(therapySession)).thenReturn(therapySession);

        TherapySession result = therapySessionService.createTherapySession(therapySession);

        assertEquals(therapySession, result);
        verify(createTherapySessionUseCase, times(1)).createTherapySession(therapySession);
    }

    @Test
    public void testFindTherapySessionById() {
        Long id = 1L;
        TherapySession therapySession = new TherapySession();
        when(findTherapySessionByIdUseCase.FindTherapySessionById(id)).thenReturn(therapySession);

        TherapySession result = therapySessionService.FindTherapySessionById(id);

        assertEquals(therapySession, result);
        verify(findTherapySessionByIdUseCase, times(1)).FindTherapySessionById(id);
    }

    @Test
    public void testFindAllTherapySessionByPatientId() {
        Long patientId = 1L;
        List<TherapySession> therapySessions = Arrays.asList(new TherapySession(), new TherapySession());
        when(findTherapySessionByPatientIdUseCase.FindAllTherapySessionByPatientId(patientId)).thenReturn(therapySessions);

        List<TherapySession> result = therapySessionService.FindAllTherapySessionByPatientId(patientId);

        assertEquals(therapySessions, result);
        verify(findTherapySessionByPatientIdUseCase, times(1)).FindAllTherapySessionByPatientId(patientId);
    }

    @Test
    public void testFindAllTherapySessionByTherapistId() {
        Long therapistId = 1L;
        List<TherapySession> therapySessions = Arrays.asList(new TherapySession(), new TherapySession());
        when(findTherapySessionByTherapistIdUseCase.FindAllTherapySessionByTherapistId(therapistId)).thenReturn(therapySessions);

        List<TherapySession> result = therapySessionService.FindAllTherapySessionByTherapistId(therapistId);

        assertEquals(therapySessions, result);
        verify(findTherapySessionByTherapistIdUseCase, times(1)).FindAllTherapySessionByTherapistId(therapistId);
    }

    @Test
    public void testFindAllTherapySessionsByPatientIdAndTherapistId() {
        Long patientId = 1L;
        Long therapistId = 1L;
        List<TherapySession> therapySessions = Arrays.asList(new TherapySession(), new TherapySession());
        when(findAllTherapySessionsByPatientIdAndTherapistIdUseCase.findAllTherapySessionsByPatientIdAndTherapistId(patientId, therapistId)).thenReturn(therapySessions);

        List<TherapySession> result = therapySessionService.findAllTherapySessionsByPatientIdAndTherapistId(patientId, therapistId);

        assertEquals(therapySessions, result);
        verify(findAllTherapySessionsByPatientIdAndTherapistIdUseCase, times(1)).findAllTherapySessionsByPatientIdAndTherapistId(patientId, therapistId);
    }

    @Test
    public void testUpdateTherapySession() {
        Long patientId = 1L;
        Long therapistId = 1L;
        LocalDate effectiveDate = LocalDate.now();
        TherapySession therapySession = new TherapySession();
        when(updateTherapistSessionUseCase.update(therapySession, patientId, therapistId, effectiveDate)).thenReturn(therapySession);

        TherapySession result = therapySessionService.update(therapySession, patientId, therapistId, effectiveDate);

        assertEquals(therapySession, result);
        verify(updateTherapistSessionUseCase, times(1)).update(therapySession, patientId, therapistId, effectiveDate);
    }
}
