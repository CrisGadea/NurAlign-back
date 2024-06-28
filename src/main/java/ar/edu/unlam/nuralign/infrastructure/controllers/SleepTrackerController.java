package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.application.services.SleepTrackerService;
import ar.edu.unlam.nuralign.infrastructure.dtos.SleepTrackerDto;
import ar.edu.unlam.nuralign.infrastructure.mappers.SleepTrackerMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/patients/{patientId}")
    public ResponseEntity<List<SleepTrackerDto>> findAllSleepTrackersByPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(sleepTrackerService.findAllSleepTrackersByPatientId(patientId).stream()
                .map(SleepTrackerMapper::toDto).toList());
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<SleepTrackerDto> findSleepTrackerByPatientIdAndEffectiveDate(
            @PathVariable Long patientId,
            @RequestParam String effectiveDate) {
        return ResponseEntity.ok(SleepTrackerMapper.toDto(sleepTrackerService.findSleepTrackerByPatientIdAndEffectiveDate(
                patientId, effectiveDate))
                );
    }

    @PatchMapping("/{patientId}")
    public ResponseEntity<SleepTrackerDto> updateSleepTracker(
            @PathVariable Long patientId,
            @RequestBody SleepTrackerDto sleepTrackerDto,
            @RequestParam String effectiveDate) {
        return ResponseEntity.ok(SleepTrackerMapper.toDto(sleepTrackerService.updateSleepTracker(
                SleepTrackerMapper.toDomain(sleepTrackerDto), patientId, effectiveDate).get())
        );
    }
    @GetMapping("patients/range/{patientId}")
    public ResponseEntity<List<SleepTrackerDto>> findAllSleepTrackersByPatientRange(@PathVariable Long patientId,
                                                                                    @RequestParam String fromDate,
                                                                                    @RequestParam String toDate)
    {
        LocalDate from = LocalDate.parse(fromDate);
        LocalDate to = LocalDate.parse(toDate);
        return ResponseEntity.ok(sleepTrackerService.findAllSleepByPatientIdByRangeDate(patientId,from,to).stream().map(SleepTrackerMapper::toDto).toList());


    }
}
