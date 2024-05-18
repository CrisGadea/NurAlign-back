package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.application.services.PatientService;
import ar.edu.unlam.nuralign.domain.models.Patient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "*")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<Patient> findPatient(@PathVariable Long patientId) {
        return patientService.findPatient(patientId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Patient>> findAllPatients() {
        return ResponseEntity.ok(patientService.findAllPatients());
    }

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.createPatient(patient));
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient, @PathVariable Long patientId) {
        return patientService.updatePatient(patient, patientId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long patientId) {
        return patientService.deletePatient(patientId) ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }

}
