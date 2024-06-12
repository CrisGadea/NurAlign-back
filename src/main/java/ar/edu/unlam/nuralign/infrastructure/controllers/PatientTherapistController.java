package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.application.services.PatientTherapistService;
import ar.edu.unlam.nuralign.infrastructure.dtos.PatientTherapistDto;
import ar.edu.unlam.nuralign.infrastructure.mappers.PatientTherapistMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient-therapist")
@CrossOrigin(origins = "*")
public class PatientTherapistController {

    private final PatientTherapistService patientTherapistService;

    public PatientTherapistController(PatientTherapistService patientTherapistService) {
        this.patientTherapistService = patientTherapistService;
    }

    @GetMapping
    public ResponseEntity<List<PatientTherapistDto>> getAll() {
        return ResponseEntity.ok(patientTherapistService.findAllPatientTherapistAssignations().stream()
                .map(PatientTherapistMapper::toDto)
                .toList());
    }

    @PostMapping
    public ResponseEntity<PatientTherapistDto> create(@RequestBody PatientTherapistDto patientTherapistDto) {
        return ResponseEntity.ok(PatientTherapistMapper.toDto(patientTherapistService.assignPatientToTherapist(
                PatientTherapistMapper.toModel(patientTherapistDto))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        patientTherapistService.deletePatientTherapistAssignation(id);
        return ResponseEntity.noContent().build();
    }

}
