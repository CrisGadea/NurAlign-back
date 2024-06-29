package ar.edu.unlam.nuralign.infrastructure.adapters;

import ar.edu.unlam.nuralign.domain.models.SleepTracker;
import ar.edu.unlam.nuralign.infrastructure.entities.SleepTrackerEntity;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaSleepTrackerRepository;
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
import static org.mockito.Mockito.when;

public class JpaSleepTrackerRepositoryAdapterTest {
    @Mock
    private JpaSleepTrackerRepository repository;

    @InjectMocks
    private JpaSleepTrackerRepositoryAdapter adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Should save sleep tracker")
    @Test
    void shouldSaveSleepTracker() {
        SleepTrackerEntity entity = new SleepTrackerEntity();
        when(repository.save(any(SleepTrackerEntity.class))).thenReturn(entity);

        SleepTrackerEntity result = repository.save(entity);

        verify(repository, times(1)).save(any(SleepTrackerEntity.class));
        assertNotNull(result);
    }

    @DisplayName("Should find sleep tracker by id")
    @Test
    void shouldFindSleepTrackerById() {
        Long id = 1L;
        SleepTrackerEntity entity = new SleepTrackerEntity();
        when(repository.findById(id)).thenReturn(Optional.of(entity));

        Optional<SleepTracker> result = adapter.findById(id);

        verify(repository, times(1)).findById(id);
        assertNotNull(result);
    }

    @DisplayName("Should find all sleep trackers")
    @Test
    void shouldFindAllSleepTrackers() {
        SleepTrackerEntity entity = new SleepTrackerEntity();
        when(repository.findAll()).thenReturn(Collections.singletonList(entity));

        var result = adapter.findAll();

        verify(repository, times(1)).findAll();
        Assertions.assertEquals(1, result.size());
    }

    @DisplayName("Should find all sleep trackers by patient id")
    @Test
    void shouldFindAllSleepTrackersByPatientId() {
        Long patientId = 1L;
        SleepTrackerEntity entity = new SleepTrackerEntity();
        when(repository.findAllByPatientId(patientId)).thenReturn(Collections.singletonList(entity));

        var result = adapter.findAllByPatientId(patientId);

        verify(repository, times(1)).findAllByPatientId(patientId);
        Assertions.assertEquals(1, result.size());
    }

    @DisplayName("Should find sleep tracker by patient id and effective date")
    @Test
    void shouldFindSleepTrackerByPatientIdAndEffectiveDate() {
        Long patientId = 1L;
        String effectiveDate = "2022-01-01";
        SleepTrackerEntity entity = new SleepTrackerEntity();
        when(repository.findByPatientIdAndEffectiveDate(patientId, LocalDate.parse(effectiveDate))).thenReturn(entity);

        SleepTracker result = adapter.findSleepTrackerByPatientIdAndEffectiveDate(patientId, effectiveDate);

        verify(repository, times(1)).findByPatientIdAndEffectiveDate(patientId, LocalDate.parse(effectiveDate));
        assertNotNull(result);
    }

    @DisplayName("Should update sleep tracker")
    @Test
    void shouldUpdateSleepTracker() {
        Long patientId = 1L;
        String effectiveDate = "2022-01-01";
        SleepTracker sleepTracker = SleepTracker.builder().build();
        SleepTrackerEntity entity = new SleepTrackerEntity();
        when(repository.findByPatientIdAndEffectiveDate(patientId, LocalDate.parse(effectiveDate))).thenReturn(entity);
        when(repository.save(any(SleepTrackerEntity.class))).thenReturn(entity);

        Optional<SleepTracker> result = adapter.update(sleepTracker, patientId, effectiveDate);

        verify(repository, times(1)).findByPatientIdAndEffectiveDate(patientId, LocalDate.parse(effectiveDate));
        verify(repository, times(1)).save(any(SleepTrackerEntity.class));
        assertNotNull(result);
    }
}
