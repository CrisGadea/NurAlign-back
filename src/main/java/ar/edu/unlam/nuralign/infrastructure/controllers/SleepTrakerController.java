package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.application.services.SleepTrakerService;
import ar.edu.unlam.nuralign.domain.models.SleepTracker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sleepTraker")
@CrossOrigin(origins = "*")
public class SleepTrakerController {
    private final SleepTrakerService sleepTrackerService;

    public SleepTrakerController(SleepTrakerService sleepTrackerService) {
        this.sleepTrackerService = sleepTrackerService;
    }

    @PostMapping
    public ResponseEntity<SleepTracker> createSleepTracker(@RequestBody SleepTracker sleepTracker) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sleepTrackerService.createSleepTraker(sleepTracker));
    }

    @GetMapping("/{sleepTrackerId}")
    public ResponseEntity<SleepTracker> findSleepTracker(@PathVariable Long sleepTrackerId) {
        return sleepTrackerService.findSleepTraker(sleepTrackerId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<SleepTracker>> findAllSleepTrackers() {
        return ResponseEntity.ok(sleepTrackerService.findAllSleepTrakers());
    }
}
