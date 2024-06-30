package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.application.services.SleepTrackerService;
import ar.edu.unlam.nuralign.domain.models.SleepTracker;
import ar.edu.unlam.nuralign.infrastructure.dtos.SleepTrackerDto;
import ar.edu.unlam.nuralign.infrastructure.mappers.SleepTrackerMapper;
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

public class SleepTrackerControllerTest {

    @Mock
    private SleepTrackerService sleepTrackerService;

    @InjectMocks
    private SleepTrackerController sleepTrackerController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateSleepTracker() {
        SleepTracker sleepTracker =SleepTracker.builder().build();
        SleepTrackerDto sleepTrackerDto = new SleepTrackerDto();

        try (MockedStatic<SleepTrackerMapper> mockedMapper = mockStatic(SleepTrackerMapper.class)) {
            mockedMapper.when(() -> SleepTrackerMapper.toDomain(sleepTrackerDto)).thenReturn(sleepTracker);
            mockedMapper.when(() -> SleepTrackerMapper.toDto(sleepTracker)).thenReturn(sleepTrackerDto);
            when(sleepTrackerService.createSleepTracker(any(SleepTracker.class))).thenReturn(sleepTracker);

            ResponseEntity<SleepTrackerDto> response = sleepTrackerController.createSleepTracker(sleepTrackerDto);

            assertEquals(HttpStatus.CREATED, response.getStatusCode());
            assertEquals(sleepTrackerDto, response.getBody());
            verify(sleepTrackerService, times(1)).createSleepTracker(sleepTracker);
        }
    }

    @Test
    public void testFindSleepTracker() {
        Long sleepTrackerId = 1L;
        SleepTracker sleepTracker = SleepTracker.builder().build();
        SleepTrackerDto sleepTrackerDto = new SleepTrackerDto();

        try (MockedStatic<SleepTrackerMapper> mockedMapper = mockStatic(SleepTrackerMapper.class)) {
            mockedMapper.when(() -> SleepTrackerMapper.toDto(sleepTracker)).thenReturn(sleepTrackerDto);
            when(sleepTrackerService.findSleepTracker(sleepTrackerId)).thenReturn(Optional.of(sleepTracker));

            ResponseEntity<SleepTrackerDto> response = sleepTrackerController.findSleepTracker(sleepTrackerId);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(sleepTrackerDto, response.getBody());
            verify(sleepTrackerService, times(1)).findSleepTracker(sleepTrackerId);
        }
    }

    @Test
    public void testFindAllSleepTrackers() {
        List<SleepTracker> sleepTrackers = Arrays.asList(SleepTracker.builder().build(), SleepTracker.builder().build());
        List<SleepTrackerDto> sleepTrackerDtos = Arrays.asList(new SleepTrackerDto(), new SleepTrackerDto());

        try (MockedStatic<SleepTrackerMapper> mockedMapper = mockStatic(SleepTrackerMapper.class)) {
            mockedMapper.when(() -> SleepTrackerMapper.toDto(any(SleepTracker.class))).thenReturn(new SleepTrackerDto());
            when(sleepTrackerService.findAllSleepTrackers()).thenReturn(sleepTrackers);

            ResponseEntity<List<SleepTrackerDto>> response = sleepTrackerController.findAllSleepTrackers();

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(sleepTrackerDtos.size(), response.getBody().size());
            verify(sleepTrackerService, times(1)).findAllSleepTrackers();
        }
    }

    @Test
    public void testFindAllSleepTrackersByPatient() {
        Long patientId = 1L;
        List<SleepTracker> sleepTrackers = Arrays.asList(SleepTracker.builder().build(), SleepTracker.builder().build());
        List<SleepTrackerDto> sleepTrackerDtos = Arrays.asList(new SleepTrackerDto(), new SleepTrackerDto());

        try (MockedStatic<SleepTrackerMapper> mockedMapper = mockStatic(SleepTrackerMapper.class)) {
            mockedMapper.when(() -> SleepTrackerMapper.toDto(any(SleepTracker.class))).thenReturn(new SleepTrackerDto());
            when(sleepTrackerService.findAllSleepTrackersByPatientId(patientId)).thenReturn(sleepTrackers);

            ResponseEntity<List<SleepTrackerDto>> response = sleepTrackerController.findAllSleepTrackersByPatient(patientId);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(sleepTrackerDtos.size(), response.getBody().size());
            verify(sleepTrackerService, times(1)).findAllSleepTrackersByPatientId(patientId);
        }
    }

    @Test
    public void testFindSleepTrackerByPatientIdAndEffectiveDate() {
        Long patientId = 1L;
        String effectiveDate = "2024-06-29";
        SleepTracker sleepTracker = SleepTracker.builder().build();
        SleepTrackerDto sleepTrackerDto = new SleepTrackerDto();

        try (MockedStatic<SleepTrackerMapper> mockedMapper = mockStatic(SleepTrackerMapper.class)) {
            mockedMapper.when(() -> SleepTrackerMapper.toDto(sleepTracker)).thenReturn(sleepTrackerDto);
            when(sleepTrackerService.findSleepTrackerByPatientIdAndEffectiveDate(patientId, effectiveDate)).thenReturn(sleepTracker);

            ResponseEntity<SleepTrackerDto> response = sleepTrackerController.findSleepTrackerByPatientIdAndEffectiveDate(patientId, effectiveDate);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(sleepTrackerDto, response.getBody());
            verify(sleepTrackerService, times(1)).findSleepTrackerByPatientIdAndEffectiveDate(patientId, effectiveDate);
        }
    }

    @Test
    public void testUpdateSleepTracker() {
        Long patientId = 1L;
        String effectiveDate = "2024-06-29";
        SleepTracker sleepTracker = SleepTracker.builder().build();
        SleepTrackerDto sleepTrackerDto = new SleepTrackerDto();

        try (MockedStatic<SleepTrackerMapper> mockedMapper = mockStatic(SleepTrackerMapper.class)) {
            mockedMapper.when(() -> SleepTrackerMapper.toDomain(sleepTrackerDto)).thenReturn(sleepTracker);
            mockedMapper.when(() -> SleepTrackerMapper.toDto(sleepTracker)).thenReturn(sleepTrackerDto);
            when(sleepTrackerService.updateSleepTracker(any(SleepTracker.class), eq(patientId), eq(effectiveDate))).thenReturn(Optional.of(sleepTracker));

            ResponseEntity<SleepTrackerDto> response = sleepTrackerController.updateSleepTracker(patientId, sleepTrackerDto, effectiveDate);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(sleepTrackerDto, response.getBody());
            verify(sleepTrackerService, times(1)).updateSleepTracker(sleepTracker, patientId, effectiveDate);
        }
    }
}