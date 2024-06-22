package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.application.services.PatientTherapistService;
import ar.edu.unlam.nuralign.infrastructure.dtos.PatientTherapistDto;
import ar.edu.unlam.nuralign.infrastructure.mappers.PatientTherapistMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patientTherapist")
@CrossOrigin(origins = "*")
public class PatientTherapistController {

    private final PatientTherapistService patientTherapistService;

    public PatientTherapistController(PatientTherapistService patientTherapistService) {
        this.patientTherapistService = patientTherapistService;
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<List<PatientTherapistDto>> getAllTherapistByPatientId(@PathVariable Long patientId) {
        return ResponseEntity.ok(patientTherapistService.findAllPatientTherapistAssignations(patientId).stream()
                .map(PatientTherapistMapper::toDto)
                .toList());
    }

    @PostMapping
    public ResponseEntity<PatientTherapistDto> create(@RequestBody PatientTherapistDto patientTherapistDto) {
        return ResponseEntity.ok(PatientTherapistMapper.toDto(patientTherapistService.assignPatientToTherapist(
                PatientTherapistMapper.toModel(patientTherapistDto))));
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<Void> delete(@PathVariable Long patientId, @RequestParam Long therapistId) {
        patientTherapistService.deletePatientTherapistAssignation(patientId, therapistId);
        return ResponseEntity.noContent().build();
    }

}
