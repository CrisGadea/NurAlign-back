package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.application.services.MedicationTrackersService;
import ar.edu.unlam.nuralign.domain.models.MedicationTracker;
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
    private final MedicationTrackersService medicationTrackerService;

    public MedicationTrackerController(MedicationTrackersService medicationTrackerService) {
        this.medicationTrackerService = medicationTrackerService;
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<MedicationTrackerDto>> getMedicationTrackersDataByPatientId(@PathVariable Long patientId) {
        return ResponseEntity.ok(medicationTrackerService.findAllMedicationTrackersByPatientId(patientId).stream()
                .map(MedicationTrackerMapper::toDto).toList());
    }

    @GetMapping
    public ResponseEntity<List<MedicationTrackerDto>> getMedicationTrackerData() {
        return ResponseEntity.ok(medicationTrackerService.findAllMedicationTrackers().stream()
                    .map(MedicationTrackerMapper::toDto)
                    .collect(Collectors.toList())
                );
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<MedicationTrackerDto> getMedicationTrackerDataByPatientIdAndEffectiveDate(
            @PathVariable Long patientId,
            @RequestParam String effectiveDate) {
        MedicationTracker tracker = medicationTrackerService.findMedicationTrackerByPatientIdAndEffectiveDate(
                patientId, LocalDate.parse(effectiveDate));
        return tracker == null ?
            ResponseEntity.ok().build() : ResponseEntity.ok(MedicationTrackerMapper.toDto(tracker));
        }

    @PostMapping
    public ResponseEntity<MedicationTrackerDto> createMedicationTrackerData(@RequestBody MedicationTrackerDto medicationTrackerDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                MedicationTrackerMapper.toDto(medicationTrackerService.createMedicationTracker(medicationTrackerDto))
        );
    }

    @PatchMapping("/{patientId}")
    public ResponseEntity<MedicationTrackerDto> updateMedicationTrackerData(
            @PathVariable Long patientId,
            @RequestParam String effectiveDate,
            @RequestBody MedicationTrackerDto medicationTrackerDto) {
        return ResponseEntity.ok(MedicationTrackerMapper.toDto(medicationTrackerService.update(
                MedicationTrackerMapper.toModel(medicationTrackerDto), patientId, effectiveDate).get())
        );
    }

}
