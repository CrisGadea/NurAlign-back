package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.domain.models.Therapist;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.edu.unlam.nuralign.application.services.TherapistService;

import java.util.List;

@RestController
@RequestMapping("/api/therapists")
public class TherapistController {

    private final TherapistService therapistService;

    public TherapistController(TherapistService therapistService) {
        this.therapistService = therapistService;
    }

    @PostMapping
    public ResponseEntity<Therapist> createTherapist(@RequestBody Therapist therapist) {
        return ResponseEntity.status(HttpStatus.CREATED).body(therapistService.createTherapist(therapist));
    }

    @GetMapping("/{therapistId}")
    public ResponseEntity<Therapist> findTherapist(@PathVariable Long therapistId) {
        return therapistService.findTherapist(therapistId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Therapist>> findAllTherapists() {
        return ResponseEntity.ok(therapistService.findAllTherapists());
    }

    @PutMapping("/{therapistId}")
    public ResponseEntity<Therapist> updateTherapist(@RequestBody Therapist therapist,
                                                               @PathVariable Long therapistId) {
        return therapistService.updateTherapist(therapist, therapistId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{therapistId}")
    public ResponseEntity<Void> deleteTherapist(@PathVariable Long therapistId) {
        return therapistService.deleteTherapist(therapistId) ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

}
