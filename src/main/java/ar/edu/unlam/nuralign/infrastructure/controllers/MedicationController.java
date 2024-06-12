package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.application.services.MedicationsService;
import ar.edu.unlam.nuralign.domain.models.Medication;
import ar.edu.unlam.nuralign.infrastructure.dtos.MedicationDto;
import ar.edu.unlam.nuralign.infrastructure.mappers.MedicationMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medications")
public class MedicationController {

    private final MedicationsService medicationService;

    public MedicationController(MedicationsService medicationService) {
        this.medicationService = medicationService;
    }

    @GetMapping("/{medicationId}")
    public ResponseEntity<MedicationDto> findMedication(@PathVariable Long medicationId) {
        return ResponseEntity.ok(MedicationMapper.toDto(medicationService.findMedication(medicationId)));
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<MedicationDto>> findMedicationsByPatientId(@PathVariable Long patientId) {
        return ResponseEntity.ok(medicationService.findMedicationsByPatientId(patientId).stream()
                .map(MedicationMapper::toDto).toList());
    }

    @GetMapping
    public ResponseEntity<List<MedicationDto>> findAllMedications() {
        return ResponseEntity.ok(medicationService.findAllMedications().stream()
                .map(MedicationMapper::toDto).toList());
    }

    @PostMapping
    public ResponseEntity<MedicationDto> createMedication(@RequestBody Medication medication) {
        return ResponseEntity.status(HttpStatus.CREATED).body(MedicationMapper.toDto(medicationService.createMedication(medication)));
    }

    @PatchMapping("/patient/{patientId}")
    public ResponseEntity<MedicationDto> updateMedication(@RequestBody MedicationDto medication,
                                                          @PathVariable Long patientId) {
        return ResponseEntity.ok(MedicationMapper.toDto(medicationService.updateMedication(
                MedicationMapper.toModel(medication), patientId).get()
        ));
    }

    @DeleteMapping("/{medicationId}")
    public ResponseEntity<Void> deleteMedication(@PathVariable Long medicationId) {
        medicationService.deleteMedication(medicationId);
        return ResponseEntity.noContent().build();
    }

}
