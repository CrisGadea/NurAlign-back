package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.application.services.MedicationTrackerService;
import ar.edu.unlam.nuralign.infrastructure.dtos.MedicationTrackerDto;
import ar.edu.unlam.nuralign.infrastructure.mappers.MedicationTrackerMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class MedicationTrackerControllerTest {

//    @Mock
//    private MedicationTrackerService medicationTrackerService;
//
//    @InjectMocks
//    private MedicationTrackerController medicationTrackerController;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void shouldReturnMedicationTrackerDataByPatientId() {
//        MedicationTrackerDto medicationTrackerDto = new MedicationTrackerDto();
//        when(medicationTrackerService.findMedicationTracker(1L)).thenReturn(any());
//
//        ResponseEntity<MedicationTrackerDto> response = medicationTrackerController.getMedicationTrackerDataByPatientId(1L);
//
//        assertEquals(200, response.getStatusCodeValue());
//        assertEquals(medicationTrackerDto, response.getBody());
//    }
//
//    @Test
//    void shouldReturnAllMedicationTrackerData() {
//        MedicationTrackerDto medicationTrackerDto = new MedicationTrackerDto();
//        when(medicationTrackerService.findAllMedicationTrackers()).thenReturn(Collections.singletonList(any()));
//
//        ResponseEntity<List<MedicationTrackerDto>> response = medicationTrackerController.getMedicationTrackerData();
//
//        assertEquals(200, response.getStatusCodeValue());
//        assertEquals(1, response.getBody().size());
//        assertEquals(medicationTrackerDto, response.getBody().get(0));
//    }
//
//    @Test
//    void shouldReturnMedicationTrackerDataByPatientIdAndEffectiveDate() {
//        List<MedicationTrackerDto> dtos = new ArrayList<>();
//        MedicationTrackerDto medicationTrackerDto = new MedicationTrackerDto();
//        dtos.add(medicationTrackerDto);
//        when(medicationTrackerService.findAllMedicationTrackerByPatientIdAndEffectiveDate(1L, LocalDate.parse("2022-01-01")))
//                .thenReturn(List.of());
//
//        ResponseEntity<List<MedicationTrackerDto>> response = medicationTrackerController.getMedicationTrackerDataByPatientIdAndEffectiveDate(1L, "2022-01-01");
//
//        assertEquals(200, response.getStatusCodeValue());
//        assertEquals(1, response.getBody().size());
//        assertEquals(medicationTrackerDto, response.getBody().get(0));
//    }
//
//    @Test
//    void shouldCreateMedicationTrackerData() {
//        MedicationTrackerDto medicationTrackerDto = new MedicationTrackerDto();
//        when(medicationTrackerService.createMedicationTracker(medicationTrackerDto)).thenReturn(any());
//
//        ResponseEntity<MedicationTrackerDto> response = medicationTrackerController.createMedicationTrackerData(medicationTrackerDto);
//
//        assertEquals(201, response.getStatusCodeValue());
//        assertEquals(medicationTrackerDto, response.getBody());
//    }
}
