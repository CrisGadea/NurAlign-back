package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.application.services.MedicationTrackersService;
import ar.edu.unlam.nuralign.domain.models.MedicationTracker;
import ar.edu.unlam.nuralign.infrastructure.dtos.MedicationTrackerDto;
import ar.edu.unlam.nuralign.infrastructure.mappers.MedicationTrackerMapper;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MedicationTrackerControllerTest {

    @Mock
    private MedicationTrackersService medicationTrackerService;

    @InjectMocks
    private MedicationTrackerController medicationTrackerController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetMedicationTrackersDataByPatientId() {
        Long patientId = 1L;
        List<MedicationTracker> trackers = Arrays.asList(new MedicationTracker(), new MedicationTracker());
        List<MedicationTrackerDto> trackerDtos = Arrays.asList(new MedicationTrackerDto(), new MedicationTrackerDto());

        try (MockedStatic<MedicationTrackerMapper> mockedMapper = mockStatic(MedicationTrackerMapper.class)) {
            mockedMapper.when(() -> MedicationTrackerMapper.toDto(any(MedicationTracker.class))).thenReturn(new MedicationTrackerDto());
            when(medicationTrackerService.findAllMedicationTrackersByPatientId(patientId)).thenReturn(trackers);

            ResponseEntity<List<MedicationTrackerDto>> response = medicationTrackerController.getMedicationTrackersDataByPatientId(patientId);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(trackerDtos.size(), response.getBody().size());
            verify(medicationTrackerService, times(1)).findAllMedicationTrackersByPatientId(patientId);
        }
    }

    @Test
    public void testGetMedicationTrackerData() {
        List<MedicationTracker> trackers = Arrays.asList(new MedicationTracker(), new MedicationTracker());
        List<MedicationTrackerDto> trackerDtos = Arrays.asList(new MedicationTrackerDto(), new MedicationTrackerDto());

        try (MockedStatic<MedicationTrackerMapper> mockedMapper = mockStatic(MedicationTrackerMapper.class)) {
            mockedMapper.when(() -> MedicationTrackerMapper.toDto(any(MedicationTracker.class))).thenReturn(new MedicationTrackerDto());
            when(medicationTrackerService.findAllMedicationTrackers()).thenReturn(trackers);

            ResponseEntity<List<MedicationTrackerDto>> response = medicationTrackerController.getMedicationTrackerData();

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(trackerDtos.size(), response.getBody().size());
            verify(medicationTrackerService, times(1)).findAllMedicationTrackers();
        }
    }

    @Test
    public void testGetMedicationTrackerDataByPatientIdAndEffectiveDate() {
        Long patientId = 1L;
        String effectiveDate = "2024-06-29";
        MedicationTracker tracker = new MedicationTracker();
        MedicationTrackerDto trackerDto = new MedicationTrackerDto();

        try (MockedStatic<MedicationTrackerMapper> mockedMapper = mockStatic(MedicationTrackerMapper.class)) {
            mockedMapper.when(() -> MedicationTrackerMapper.toDto(tracker)).thenReturn(trackerDto);
            when(medicationTrackerService.findMedicationTrackerByPatientIdAndEffectiveDate(patientId, LocalDate.parse(effectiveDate))).thenReturn(tracker);

            ResponseEntity<MedicationTrackerDto> response = medicationTrackerController.getMedicationTrackerDataByPatientIdAndEffectiveDate(patientId, effectiveDate);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(trackerDto, response.getBody());
            verify(medicationTrackerService, times(1)).findMedicationTrackerByPatientIdAndEffectiveDate(patientId, LocalDate.parse(effectiveDate));
        }
    }

    @Test
    public void testCreateMedicationTrackerData() {
        MedicationTracker tracker = new MedicationTracker();
        MedicationTrackerDto trackerDto = new MedicationTrackerDto();

        try (MockedStatic<MedicationTrackerMapper> mockedMapper = mockStatic(MedicationTrackerMapper.class)) {
            mockedMapper.when(() -> MedicationTrackerMapper.toModel(trackerDto)).thenReturn(tracker);
            mockedMapper.when(() -> MedicationTrackerMapper.toDto(tracker)).thenReturn(trackerDto);
            when(medicationTrackerService.createMedicationTracker(any(MedicationTracker.class))).thenReturn(tracker);

            ResponseEntity<MedicationTrackerDto> response = medicationTrackerController.createMedicationTrackerData(trackerDto);

            assertEquals(HttpStatus.CREATED, response.getStatusCode());
            assertEquals(trackerDto, response.getBody());
            verify(medicationTrackerService, times(1)).createMedicationTracker(tracker);
        }
    }

    @Test
    public void testUpdateMedicationTrackerData() {
        Long patientId = 1L;
        String effectiveDate = "2024-06-29";
        MedicationTracker tracker = new MedicationTracker();
        MedicationTrackerDto trackerDto = new MedicationTrackerDto();

        try (MockedStatic<MedicationTrackerMapper> mockedMapper = mockStatic(MedicationTrackerMapper.class)) {
            mockedMapper.when(() -> MedicationTrackerMapper.toModel(trackerDto)).thenReturn(tracker);
            mockedMapper.when(() -> MedicationTrackerMapper.toDto(tracker)).thenReturn(trackerDto);
            when(medicationTrackerService.update(any(MedicationTracker.class), eq(patientId), eq(effectiveDate))).thenReturn(Optional.of(tracker));

            ResponseEntity<MedicationTrackerDto> response = medicationTrackerController.updateMedicationTrackerData(patientId, effectiveDate, trackerDto);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(trackerDto, response.getBody());
            verify(medicationTrackerService, times(1)).update(tracker, patientId, effectiveDate);
        }
    }
}