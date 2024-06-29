package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.application.services.PatientService;
import ar.edu.unlam.nuralign.domain.models.Patient;
import ar.edu.unlam.nuralign.infrastructure.dtos.PatientDto;
import ar.edu.unlam.nuralign.infrastructure.mappers.PatientMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "*")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<PatientDto> findPatient(@PathVariable Long patientId) {
        Optional<Patient> patient = patientService.findPatient(patientId);
        return patient.map(value -> ResponseEntity.ok(PatientMapper.mapToDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<PatientDto>> findAllPatients() {
        return ResponseEntity.ok(patientService.findAllPatients().stream()
                .map(PatientMapper::mapToDto)
                .toList());
    }

    @PostMapping
    public ResponseEntity<PatientDto> createPatient(@RequestBody PatientDto patient) {
        return ResponseEntity.ok(PatientMapper.mapToDto(patientService.createPatient(PatientMapper.mapToDomain(patient))));
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<PatientDto> updatePatient(@RequestBody PatientDto patient, @PathVariable Long patientId) {
        return ResponseEntity.ok(PatientMapper.mapToDto(
                patientService.updatePatient(PatientMapper.mapToDomain(patient), patientId).get())
        );
                //.orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long patientId) {
        return patientService.deletePatient(patientId) ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }

}
