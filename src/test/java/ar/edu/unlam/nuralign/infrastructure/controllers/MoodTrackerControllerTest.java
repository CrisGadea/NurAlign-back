package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.application.services.MoodTrackerService;
import ar.edu.unlam.nuralign.domain.models.MoodTracker;
import ar.edu.unlam.nuralign.infrastructure.dtos.MoodTrackerDto;
import ar.edu.unlam.nuralign.infrastructure.exceptions.ResourceNotFoundException;
import ar.edu.unlam.nuralign.infrastructure.mappers.MoodTrackerMapper;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MoodTrackerControllerTest {

    @Mock
    private MoodTrackerService moodTrackerService;

    @InjectMocks
    private MoodTrackerController moodTrackerController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetMoodTrackerDataByPatientId() {
        Long patientId = 1L;
        MoodTracker moodTracker = new MoodTracker();
        MoodTrackerDto moodTrackerDto = MoodTrackerDto.builder().build();

        try (MockedStatic<MoodTrackerMapper> mockedMapper = mockStatic(MoodTrackerMapper.class)) {
            mockedMapper.when(() -> MoodTrackerMapper.toDto(moodTracker)).thenReturn(moodTrackerDto);
            when(moodTrackerService.findMoodTracker(patientId)).thenReturn(moodTracker);

            ResponseEntity<MoodTrackerDto> response = moodTrackerController.getMoodTrackerDataByPatientId(patientId);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(moodTrackerDto, response.getBody());
            verify(moodTrackerService, times(1)).findMoodTracker(patientId);
        }
    }

    @Test
    public void testGetMoodTrackerData() {
        List<MoodTracker> moodTrackers = Arrays.asList(new MoodTracker(), new MoodTracker());
        List<MoodTrackerDto> moodTrackerDtos = Arrays.asList(MoodTrackerDto.builder().build(), MoodTrackerDto.builder().build());

        try (MockedStatic<MoodTrackerMapper> mockedMapper = mockStatic(MoodTrackerMapper.class)) {
            mockedMapper.when(() -> MoodTrackerMapper.toDto(any(MoodTracker.class))).thenReturn(MoodTrackerDto.builder().build());
            when(moodTrackerService.findAllMoodTrackers()).thenReturn(moodTrackers);

            ResponseEntity<List<MoodTrackerDto>> response = moodTrackerController.getMoodTrackerData();

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(moodTrackerDtos.size(), response.getBody().size());
            verify(moodTrackerService, times(1)).findAllMoodTrackers();
        }
    }

    @Test
    public void testGetMoodTrackerDataByPatientIdAndEffectiveDate() {
        Long patientId = 1L;
        String effectiveDate = "2024-06-29";
        MoodTracker moodTracker = new MoodTracker();
        MoodTrackerDto moodTrackerDto = MoodTrackerDto.builder().build();

        try (MockedStatic<MoodTrackerMapper> mockedMapper = mockStatic(MoodTrackerMapper.class)) {
            mockedMapper.when(() -> MoodTrackerMapper.toDto(moodTracker)).thenReturn(moodTrackerDto);
            when(moodTrackerService.findMoodTrackerByPatientIdAndEffectiveDate(patientId, effectiveDate)).thenReturn(Optional.of(moodTracker));

            ResponseEntity<?> response = moodTrackerController.getMoodTrackerDataByPatientIdAndEffectiveDate(patientId, effectiveDate);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(moodTrackerDto, response.getBody());
            verify(moodTrackerService, times(1)).findMoodTrackerByPatientIdAndEffectiveDate(patientId, effectiveDate);
        }
    }

    @Test
    public void testCreateMoodTrackerData() {
        MoodTracker moodTracker = new MoodTracker();
        MoodTrackerDto moodTrackerDto = MoodTrackerDto.builder().build();

        try (MockedStatic<MoodTrackerMapper> mockedMapper = mockStatic(MoodTrackerMapper.class)) {
            mockedMapper.when(() -> MoodTrackerMapper.toModel(moodTrackerDto)).thenReturn(moodTracker);
            mockedMapper.when(() -> MoodTrackerMapper.toDto(moodTracker)).thenReturn(moodTrackerDto);
            when(moodTrackerService.createMoodTracker(any(MoodTracker.class))).thenReturn(moodTracker);

            ResponseEntity<MoodTrackerDto> response = moodTrackerController.createMoodTrackerData(moodTrackerDto);

            assertEquals(HttpStatus.CREATED, response.getStatusCode());
            assertEquals(moodTrackerDto, response.getBody());
            verify(moodTrackerService, times(1)).createMoodTracker(moodTracker);
        }
    }

    @Test
    public void testUpdateMoodTrackerData() {
        Long patientId = 1L;
        String effectiveDate = "2024-06-29";
        MoodTracker moodTracker = new MoodTracker();
        MoodTrackerDto moodTrackerDto = MoodTrackerDto.builder().build();

        try (MockedStatic<MoodTrackerMapper> mockedMapper = mockStatic(MoodTrackerMapper.class)) {
            mockedMapper.when(() -> MoodTrackerMapper.toModel(moodTrackerDto)).thenReturn(moodTracker);
            mockedMapper.when(() -> MoodTrackerMapper.toDto(moodTracker)).thenReturn(moodTrackerDto);
            when(moodTrackerService.updateMoodTracker(any(MoodTracker.class), eq(patientId), eq(effectiveDate))).thenReturn(Optional.of(moodTracker));

            ResponseEntity<MoodTrackerDto> response = moodTrackerController.updateMoodTrackerData(patientId, moodTrackerDto, effectiveDate);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(moodTrackerDto, response.getBody());
            verify(moodTrackerService, times(1)).updateMoodTracker(moodTracker, patientId, effectiveDate);
        }
    }

    @Test
    public void testGetAllMoodTrackerDataByPatientId() {
        Long patientId = 1L;
        List<MoodTracker> moodTrackers = Arrays.asList(new MoodTracker(), new MoodTracker());
        List<MoodTrackerDto> moodTrackerDtos = Arrays.asList(MoodTrackerDto.builder().build(), MoodTrackerDto.builder().build());

        try (MockedStatic<MoodTrackerMapper> mockedMapper = mockStatic(MoodTrackerMapper.class)) {
            mockedMapper.when(() -> MoodTrackerMapper.toDto(any(MoodTracker.class))).thenReturn(MoodTrackerDto.builder().build());
            when(moodTrackerService.findAllMoodTrackersByPatientId(patientId)).thenReturn(moodTrackers);

            ResponseEntity<List<MoodTrackerDto>> response = moodTrackerController.getAllMoodTrackerDataByPatientId(patientId);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(moodTrackerDtos.size(), response.getBody().size());
            verify(moodTrackerService, times(1)).findAllMoodTrackersByPatientId(patientId);
        }
    }
}