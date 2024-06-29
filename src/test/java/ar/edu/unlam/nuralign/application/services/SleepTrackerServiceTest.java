package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.sleepTracker.*;
import ar.edu.unlam.nuralign.domain.models.SleepTracker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class SleepTrackerServiceTest {
    @Mock
    private CreateSleepTrackerUseCase createSleepTrackerUseCase;

    @Mock
    private FindSleepTrackerUseCase findSleepTrackerUseCase;

    @Mock
    private FindAllSleepTrackersUseCase findAllSleepTrackersUseCase;

    @Mock
    private FindAllSleepTrackersByPatientUseCase findAllSleepTrackersByPatientUseCase;

    @Mock
    private FindSleepTrackerByPatientIdAndEffectiveDateUseCase findSleepTrackerByPatientIdAndEffectiveDateUseCase;

    @Mock
    private UpdateSleepTrackerUseCase updateSleepTrackerUseCase;

    @InjectMocks
    private SleepTrackerService sleepTrackerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Should create sleep tracker")
    @Test
    void shouldCreateSleepTracker() {
        SleepTracker sleepTracker = SleepTracker.builder().build();
        when(createSleepTrackerUseCase.createSleepTracker(sleepTracker)).thenReturn(sleepTracker);

        SleepTracker result = sleepTrackerService.createSleepTracker(sleepTracker);

        verify(createSleepTrackerUseCase, times(1)).createSleepTracker(sleepTracker);
        assertEquals(sleepTracker, result);
    }

    @DisplayName("Should find sleep tracker by id")
    @Test
    void shouldFindSleepTracker() {
        Long id = 1L;
        SleepTracker sleepTracker = SleepTracker.builder().build();
        when(findSleepTrackerUseCase.findSleepTracker(id)).thenReturn(Optional.of(sleepTracker));

        Optional<SleepTracker> result = sleepTrackerService.findSleepTracker(id);

        verify(findSleepTrackerUseCase, times(1)).findSleepTracker(id);
        assertTrue(result.isPresent());
        assertEquals(sleepTracker, result.get());
    }

    @DisplayName("Should find all sleep trackers")
    @Test
    void shouldFindAllSleepTrackers() {
        List<SleepTracker> sleepTrackers = Collections.singletonList(SleepTracker.builder().build());
        when(findAllSleepTrackersUseCase.findAllSleepTrackers()).thenReturn(sleepTrackers);

        List<SleepTracker> result = sleepTrackerService.findAllSleepTrackers();

        verify(findAllSleepTrackersUseCase, times(1)).findAllSleepTrackers();
        assertEquals(sleepTrackers, result);
    }

    @DisplayName("Should find all sleep trackers by patient id")
    @Test
    void shouldFindAllSleepTrackersByPatientId() {
        Long patientId = 1L;
        List<SleepTracker> sleepTrackers = Collections.singletonList(SleepTracker.builder().build());
        when(findAllSleepTrackersByPatientUseCase.findAllSleepTrackersByPatientId(patientId)).thenReturn(sleepTrackers);

        List<SleepTracker> result = sleepTrackerService.findAllSleepTrackersByPatientId(patientId);

        verify(findAllSleepTrackersByPatientUseCase, times(1)).findAllSleepTrackersByPatientId(patientId);
        assertEquals(sleepTrackers, result);
    }

    @DisplayName("Should find sleep tracker by patient id and effective date")
    @Test
    void shouldFindSleepTrackerByPatientIdAndEffectiveDate() {
        Long patientId = 1L;
        String effectiveDate = "2022-01-01";
        SleepTracker sleepTracker = SleepTracker.builder().build();
        when(findSleepTrackerByPatientIdAndEffectiveDateUseCase.findSleepTrackerByPatientIdAndEffectiveDate(patientId, effectiveDate)).thenReturn(sleepTracker);

        SleepTracker result = sleepTrackerService.findSleepTrackerByPatientIdAndEffectiveDate(patientId, effectiveDate);

        verify(findSleepTrackerByPatientIdAndEffectiveDateUseCase, times(1)).findSleepTrackerByPatientIdAndEffectiveDate(patientId, effectiveDate);
        assertEquals(sleepTracker, result);
    }
}
