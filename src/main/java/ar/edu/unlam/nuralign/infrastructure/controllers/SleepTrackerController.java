package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.application.services.SleepTrackerService;
import ar.edu.unlam.nuralign.domain.models.SleepTracker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sleepTracker")
@CrossOrigin(origins = "*")
public class SleepTrackerController {
    private final SleepTrackerService sleepTrackerService;

    public SleepTrackerController(SleepTrackerService sleepTrackerService) {
        this.sleepTrackerService = sleepTrackerService;
    }

    @PostMapping
    public ResponseEntity<SleepTracker> createSleepTracker(@RequestBody SleepTracker sleepTracker) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sleepTrackerService.createSleepTracker(sleepTracker));
    }

    @GetMapping("/{sleepTrackerId}")
    public ResponseEntity<SleepTracker> findSleepTracker(@PathVariable Long sleepTrackerId) {
        return sleepTrackerService.findSleepTracker(sleepTrackerId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<SleepTracker>> findAllSleepTrackers() {
        return ResponseEntity.ok(sleepTrackerService.findAllSleepTrackers());
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<SleepTracker>> findAllSleepTrackersByPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(sleepTrackerService.findAllSleepTrackersByPatientId(patientId));
    }
}
