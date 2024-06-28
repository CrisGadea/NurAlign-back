package ar.edu.unlam.nuralign.infrastructure.adapters;


import ar.edu.unlam.nuralign.domain.models.MoodTracker;
import ar.edu.unlam.nuralign.infrastructure.entities.MoodTrackerEntity;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaMoodTrackerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class JpaMoodTrackerRepositoryAdapterTest {
    @Mock
    private JpaMoodTrackerRepository repository;

    @InjectMocks
    private JpaMoodTrackerRepositoryAdapter adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Should save mood tracker")
    @Test
    void shouldSaveMoodTracker() {
        MoodTracker moodTracker = new MoodTracker();
        MoodTrackerEntity entity = new MoodTrackerEntity();
        when(repository.save(any(MoodTrackerEntity.class))).thenReturn(entity);

        MoodTracker result = adapter.save(moodTracker);

        verify(repository, times(1)).save(any(MoodTrackerEntity.class));
        assertNotNull(result);
    }

    @DisplayName("Should find all mood trackers")
    @Test
    void shouldFindAllMoodTrackers() {
        MoodTrackerEntity entity = new MoodTrackerEntity();
        when(repository.findAll()).thenReturn(Collections.singletonList(entity));

        var result = adapter.findAll();

        verify(repository, times(1)).findAll();
        assertEquals(1, result.size());
    }

    @DisplayName("Should find mood tracker by id")
    @Test
    void shouldFindMoodTrackerById() {
        Long id = 1L;
        MoodTrackerEntity entity = new MoodTrackerEntity();
        when(repository.findById(id)).thenReturn(Optional.of(entity));

        MoodTracker result = adapter.findById(id);

        verify(repository, times(1)).findById(id);
        assertNotNull(result);
    }

    @DisplayName("Should find all mood trackers by patient id")
    @Test
    void shouldFindAllMoodTrackersByPatientId() {
        Long patientId = 1L;
        MoodTrackerEntity entity = new MoodTrackerEntity();
        when(repository.findAllByPatientId(patientId)).thenReturn(Collections.singletonList(entity));

        var result = adapter.findAllByPatientId(patientId);

        verify(repository, times(1)).findAllByPatientId(patientId);
        assertEquals(1, result.size());
    }

    @DisplayName("Should find mood tracker by patient id and effective date")
    @Test
    void shouldFindMoodTrackerByPatientIdAndEffectiveDate() {
        Long patientId = 1L;
        String effectiveDate = "2022-01-01";
        MoodTrackerEntity entity = new MoodTrackerEntity();
        when(repository.findByPatientIdAndEffectiveDate(patientId, LocalDate.parse(effectiveDate))).thenReturn(entity);

        MoodTracker result = adapter.findByPatientIdAndEffectiveDate(patientId, effectiveDate);

        verify(repository, times(1)).findByPatientIdAndEffectiveDate(patientId, LocalDate.parse(effectiveDate));
        assertNotNull(result);
    }

    @DisplayName("Should update mood tracker")
    @Test
    void shouldUpdateMoodTracker() {
        Long patientId = 1L;
        String effectiveDate = "2022-01-01";
        MoodTracker moodTracker = new MoodTracker();
        MoodTrackerEntity entity = new MoodTrackerEntity();
        when(repository.findByPatientIdAndEffectiveDate(patientId, LocalDate.parse(effectiveDate))).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);

        Optional<MoodTracker> result = adapter.update(moodTracker, patientId, effectiveDate);

        verify(repository, times(1)).findByPatientIdAndEffectiveDate(patientId, LocalDate.parse(effectiveDate));
        verify(repository, times(1)).save(entity);
        assertTrue(result.isPresent());
    }
}
