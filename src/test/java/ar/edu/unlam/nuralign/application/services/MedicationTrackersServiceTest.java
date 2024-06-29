package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.medicationTracker.*;
import ar.edu.unlam.nuralign.domain.models.MedicationTracker;
import ar.edu.unlam.nuralign.infrastructure.dtos.MedicationTrackerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class MedicationTrackersServiceTest {
    @Mock
    private FindMedicationTrackerUseCase findMedicationTrackerUseCase;
    @Mock
    private FindMedicationTrackerByEffectiveDateUseCase findMedicationTrackerByEffectiveDateUseCase;
    @Mock
    private FindAllMedicationTrackersByPatientIdUseCase findAllMedicationTrackersByPatientIdUseCase;
    @Mock
    private FindAllMedicationTrackersUseCase findAllMedicationTrackersUseCase;
    @Mock
    private CreateMedicationTrackerUseCase createMedicationTrackerUseCase;
    @Mock
    private FindMedicationTrackerByPatientIdAndEffectiveDateUseCase findMedicationTrackerByPatientIdAndEffectiveDateUseCase;
    @Mock
    private UpdateMedicationTrackerUseCase updateMedicationTrackerUseCase;

    @InjectMocks
    private MedicationTrackersService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Should find medication tracker by id")
    @Test
    void shouldFindMedicationTrackerById() {
        Long id = 1L;
        MedicationTracker tracker = new MedicationTracker();
        when(findMedicationTrackerUseCase.findMedicationTracker(id)).thenReturn(tracker);

        MedicationTracker result = service.findMedicationTracker(id);

        verify(findMedicationTrackerUseCase, times(1)).findMedicationTracker(id);
        assertNotNull(result);
    }

    @DisplayName("Should find medication tracker by effective date")
    @Test
    void shouldFindMedicationTrackerByEffectiveDate() {
        String effectiveDate = "2022-01-01";
        MedicationTracker tracker = new MedicationTracker();
        when(findMedicationTrackerByEffectiveDateUseCase.findMedicationTrackerByEffectiveDate(effectiveDate)).thenReturn(tracker);

        MedicationTracker result = service.findMedicationTrackerByEffectiveDate(effectiveDate);

        verify(findMedicationTrackerByEffectiveDateUseCase, times(1)).findMedicationTrackerByEffectiveDate(effectiveDate);
        assertNotNull(result);
    }

    @DisplayName("Should find all medication trackers by patient id")
    @Test
    void shouldFindAllMedicationTrackersByPatientId() {
        Long patientId = 1L;
        MedicationTracker tracker = new MedicationTracker();
        when(findAllMedicationTrackersByPatientIdUseCase.findAllMedicationTrackersByPatientId(patientId)).thenReturn(Collections.singletonList(tracker));

        var result = service.findAllMedicationTrackersByPatientId(patientId);

        verify(findAllMedicationTrackersByPatientIdUseCase, times(1)).findAllMedicationTrackersByPatientId(patientId);
        assertEquals(1, result.size());
    }

    @DisplayName("Should create medication tracker")
    @Test
    void shouldCreateMedicationTracker() {
        MedicationTrackerDto dto = new MedicationTrackerDto();
        MedicationTracker tracker = new MedicationTracker();
        when(createMedicationTrackerUseCase.createMedicationTracker(dto)).thenReturn(tracker);

        MedicationTracker result = service.createMedicationTracker(dto);

        verify(createMedicationTrackerUseCase, times(1)).createMedicationTracker(dto);
        assertNotNull(result);
    }

    @DisplayName("Should find medication tracker by patient id and effective date")
    @Test
    void shouldFindMedicationTrackerByPatientIdAndEffectiveDate() {
        Long patientId = 1L;
        String effectiveDate = "2022-01-01";
        MedicationTracker tracker = new MedicationTracker();
        when(findMedicationTrackerByPatientIdAndEffectiveDateUseCase.findMedicationTrackerByPatientIdAndEffectiveDate(patientId, LocalDate.parse(effectiveDate))).thenReturn(tracker);

        MedicationTracker result = service.findMedicationTrackerByPatientIdAndEffectiveDate(patientId, LocalDate.parse(effectiveDate));

        verify(findMedicationTrackerByPatientIdAndEffectiveDateUseCase, times(1)).findMedicationTrackerByPatientIdAndEffectiveDate(patientId, LocalDate.parse(effectiveDate));
        assertNotNull(result);
    }
}
