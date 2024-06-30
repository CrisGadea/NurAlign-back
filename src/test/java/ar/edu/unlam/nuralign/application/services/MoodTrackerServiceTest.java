package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.moodTracker.*;
import ar.edu.unlam.nuralign.domain.models.MoodTracker;
import ar.edu.unlam.nuralign.infrastructure.dtos.MoodTrackerDto;
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
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class MoodTrackerServiceTest {
    @Mock
    private CreateMoodTrackerUseCase createMoodTrackerUseCase;
    @Mock
    private FindMoodTrackerUseCase findMoodTrackerUseCase;
    @Mock
    private FindAllMoodTrackersUseCase findAllMoodTrackersUseCase;
    @Mock
    private FindMoodTrackerByPatientIdAndEffectiveDateUseCase findAllByPatientIdAndEffectiveDateUseCase;
    @Mock
    private UpdateMoodTrackerUseCase updateMoodTrackerUseCase;
    @Mock
    private FindAllMoodTrackersByPatientIdUseCase findAllByPatientIdUseCase;

    @InjectMocks
    private MoodTrackerService moodTrackerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Should create mood tracker")
    @Test
    void shouldCreateMoodTracker() {
        MoodTrackerDto moodTrackerDto = MoodTrackerDto.builder().build();
        MoodTracker moodTracker = new MoodTracker();
        when(createMoodTrackerUseCase.createMoodTracker(moodTracker)).thenReturn(moodTracker);

        MoodTracker result = moodTrackerService.createMoodTracker(moodTracker);

        verify(createMoodTrackerUseCase, times(1)).createMoodTracker(moodTracker);
        assertNotNull(result);
    }

    @DisplayName("Should find mood tracker by id")
    @Test
    void shouldFindMoodTracker() {
        Long id = 1L;
        MoodTracker moodTracker = new MoodTracker();
        when(findMoodTrackerUseCase.findMoodTracker(id)).thenReturn(moodTracker);

        MoodTracker result = moodTrackerService.findMoodTracker(id);

        verify(findMoodTrackerUseCase, times(1)).findMoodTracker(id);
        assertNotNull(result);
    }

    @DisplayName("Should find all mood trackers by patient id")
    @Test
    void shouldFindAllMoodTrackersByPatientId() {
        Long patientId = 1L;
        MoodTracker moodTracker = new MoodTracker();
        when(findAllByPatientIdUseCase.findAllMoodTrackersByPatientId(patientId)).thenReturn(Collections.singletonList(moodTracker));

        var result = moodTrackerService.findAllMoodTrackersByPatientId(patientId);

        verify(findAllByPatientIdUseCase, times(1)).findAllMoodTrackersByPatientId(patientId);
        assertEquals(1, result.size());
    }

    @DisplayName("Should find mood tracker by patient id and effective date")
    @Test
    void shouldFindMoodTrackerByPatientIdAndEffectiveDate() {
        Long patientId = 1L;
        String effectiveDate = "2022-01-01";
        MoodTracker moodTracker = new MoodTracker();
        when(findAllByPatientIdAndEffectiveDateUseCase.findMoodTrackerByPatientIdAndEffectiveDate(patientId, effectiveDate)).thenReturn(Optional.of(moodTracker));

        Optional<MoodTracker> result = moodTrackerService.findMoodTrackerByPatientIdAndEffectiveDate(patientId, effectiveDate);

        verify(findAllByPatientIdAndEffectiveDateUseCase, times(1)).findMoodTrackerByPatientIdAndEffectiveDate(patientId, effectiveDate);
        assertNotNull(result);
    }

    @DisplayName("Should update mood tracker")
    @Test
    void shouldUpdateMoodTracker() {
        Long patientId = 1L;
        Long therapistId = 1L;
        String effectiveDate = "2022-01-01";
        MoodTrackerDto moodTrackerDto = MoodTrackerDto.builder().build();
        MoodTracker moodTracker = new MoodTracker();
        when(updateMoodTrackerUseCase.updateMoodTracker(moodTracker, patientId, effectiveDate)).thenReturn(Optional.of(moodTracker));

        Optional<MoodTracker> result = moodTrackerService.updateMoodTracker(moodTracker, patientId, effectiveDate);

        verify(updateMoodTrackerUseCase, times(1)).updateMoodTracker(moodTracker, patientId, effectiveDate);
        assertNotNull(result);
    }

    @DisplayName("Should find all mood trackers")
    @Test
    void shouldFindAllMoodTrackers() {
        MoodTracker moodTracker = new MoodTracker();
        when(findAllMoodTrackersUseCase.findAllMoodTrackers()).thenReturn(Collections.singletonList(moodTracker));

        var result = moodTrackerService.findAllMoodTrackers();

        verify(findAllMoodTrackersUseCase, times(1)).findAllMoodTrackers();
        assertEquals(1, result.size());
    }
}
