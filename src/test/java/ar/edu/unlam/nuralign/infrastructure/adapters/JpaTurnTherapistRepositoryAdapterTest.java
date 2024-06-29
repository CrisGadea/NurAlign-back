package ar.edu.unlam.nuralign.infrastructure.adapters;

import ar.edu.unlam.nuralign.domain.models.TherapySession;
import ar.edu.unlam.nuralign.infrastructure.entities.TherapySessionEntity;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaTherapySessionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class JpaTurnTherapistRepositoryAdapterTest {
//    @Mock
//    private JpaTherapySessionRepository repository;
//
//    @InjectMocks
//    private JpaTherapySessionRepositoryAdapter adapter;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @DisplayName("Should save therapy session")
//    @Test
//    void shouldSaveTherapySession() {
//        TherapySession therapySession = new TherapySession();
//        TherapySessionEntity entity = new TherapySessionEntity();
//        when(repository.save(any(TherapySessionEntity.class))).thenReturn(entity);
//
//        TherapySession result = adapter.save(therapySession);
//
//        verify(repository, times(1)).save(any(TherapySessionEntity.class));
//        assertNotNull(result);
//    }
//
//    @DisplayName("Should find all therapy sessions by patient id")
//    @Test
//    void shouldFindAllTherapySessionsByPatientId() {
//        Long patientId = 1L;
//        TherapySessionEntity entity = new TherapySessionEntity();
//        when(repository.findAllByPatientId(patientId)).thenReturn(Collections.singletonList(entity));
//
//        var result = adapter.findAllByPatientId(patientId);
//
//        verify(repository, times(1)).findAllByPatientId(patientId);
//        Assertions.assertEquals(1, result.size());
//    }
//
//    @DisplayName("Should find therapy session by id")
//    @Test
//    void shouldFindTherapySessionById() {
//        Long id = 1L;
//        TherapySessionEntity entity = new TherapySessionEntity();
//        when(repository.findById(id)).thenReturn(Optional.of(entity));
//
//        TherapySession result = adapter.findById(id);
//
//        verify(repository, times(1)).findById(id);
//        assertNotNull(result);
//    }
//
//    @DisplayName("Should update therapy session")
//    @Test
//    void shouldUpdateTherapySession() {
//        Long patientId = 1L;
//        Long therapistId = 1L;
//        LocalDate effectiveDate = LocalDate.now();
//        TherapySession therapySession = new TherapySession();
//        TherapySessionEntity entity = new TherapySessionEntity();
//        when(repository.findByTherapistIdAndPatientIdAndEffectiveDate(patientId, therapistId, String.valueOf(effectiveDate))).thenReturn(entity);
//        when(repository.save(any(TherapySessionEntity.class))).thenReturn(entity);
//
//        TherapySession result = adapter.update(therapySession, patientId, therapistId, effectiveDate);
//
//        verify(repository, times(1)).findByTherapistIdAndPatientIdAndEffectiveDate(patientId, therapistId, String.valueOf(effectiveDate));
//        verify(repository, times(1)).save(any(TherapySessionEntity.class));
//        assertNotNull(result);
//    }
}
