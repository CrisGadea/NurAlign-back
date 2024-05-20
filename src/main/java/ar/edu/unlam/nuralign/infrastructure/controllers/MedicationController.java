package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.application.services.MedicationService;
import ar.edu.unlam.nuralign.domain.models.Medication;
import ar.edu.unlam.nuralign.infrastructure.dtos.MedicationDto;
import ar.edu.unlam.nuralign.infrastructure.mappers.MedicationMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medication")
public class MedicationController {

    private final MedicationService medicationService;

    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @GetMapping("/{medicationId}")
    public ResponseEntity<MedicationDto> findMedication(@PathVariable Long medicationId) {
        return ResponseEntity.ok(MedicationMapper.toDto(medicationService.findMedication(medicationId)));
    }

    @GetMapping
    public ResponseEntity<List<MedicationDto>> findAllMedications() {
        return ResponseEntity.ok(medicationService.findAllMedications().stream()
                .map(MedicationMapper::toDto).toList());
    }

    @PostMapping
    public ResponseEntity<MedicationDto> createMedication(@RequestBody Medication medication) {
        return ResponseEntity.ok(MedicationMapper.toDto(medicationService.createMedication(medication)));
    }
}
