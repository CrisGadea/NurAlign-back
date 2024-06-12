package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.application.services.MedicationTrackerService;
import ar.edu.unlam.nuralign.infrastructure.dtos.MedicationTrackerDto;
import ar.edu.unlam.nuralign.infrastructure.mappers.MedicationTrackerMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/medicationTracker")
public class MedicationTrackerController {
    private final MedicationTrackerService medicationTrackerService;

    public MedicationTrackerController(MedicationTrackerService medicationTrackerService) {
        this.medicationTrackerService = medicationTrackerService;
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<MedicationTrackerDto> getMedicationTrackerDataByPatientId(@PathVariable Long patientId) {
        return ResponseEntity.ok(MedicationTrackerMapper.toDto(medicationTrackerService.findMedicationTracker(patientId)));
    }

    @GetMapping
    public ResponseEntity<List<MedicationTrackerDto>> getMedicationTrackerData() {
        return ResponseEntity.ok(medicationTrackerService.findAllMedicationTrackers().stream()
                    .map(MedicationTrackerMapper::toDto)
                    .collect(Collectors.toList())
                );
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<List<MedicationTrackerDto>> getMedicationTrackerDataByPatientIdAndEffectiveDate(
            @PathVariable Long patientId,
            @RequestParam String effectiveDate) {
        return ResponseEntity.ok(medicationTrackerService.findAllMedicationTrackerByPatientIdAndEffectiveDate(
                patientId, LocalDate.parse(effectiveDate)).stream()
                    .map(MedicationTrackerMapper::toDto)
                    .collect(Collectors.toList())
                );
    }

    @PostMapping
    public ResponseEntity<MedicationTrackerDto> createMedicationTrackerData(@RequestBody MedicationTrackerDto medicationTrackerDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                MedicationTrackerMapper.toDto(medicationTrackerService.createMedicationTracker(medicationTrackerDto))
        );
    }

}