package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.application.services.SleepTrackerService;
import ar.edu.unlam.nuralign.domain.models.SleepTracker;
import ar.edu.unlam.nuralign.infrastructure.dtos.SleepTrackerDto;
import ar.edu.unlam.nuralign.infrastructure.mappers.SleepTrackerMapper;
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
    public ResponseEntity<SleepTrackerDto> createSleepTracker(@RequestBody SleepTrackerDto sleepTracker) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                SleepTrackerMapper.toDto(
                        sleepTrackerService.createSleepTracker(SleepTrackerMapper.toDomain(sleepTracker))
                ));
    }

    @GetMapping("/{sleepTrackerId}")
    public ResponseEntity<SleepTrackerDto> findSleepTracker(@PathVariable Long sleepTrackerId) {
        return ResponseEntity.ok().body(SleepTrackerMapper.toDto(
                sleepTrackerService.findSleepTracker(sleepTrackerId).get())
        );
    }

    @GetMapping
    public ResponseEntity<List<SleepTrackerDto>> findAllSleepTrackers() {
        return ResponseEntity.ok(sleepTrackerService.findAllSleepTrackers().stream()
                .map(SleepTrackerMapper::toDto).toList());
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<SleepTrackerDto>> findAllSleepTrackersByPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(sleepTrackerService.findAllSleepTrackersByPatientId(patientId).stream()
                .map(SleepTrackerMapper::toDto).toList());
    }
}
