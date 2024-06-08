package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.application.services.MoodTrackerService;
import ar.edu.unlam.nuralign.infrastructure.dtos.MoodTrackerDto;
import ar.edu.unlam.nuralign.infrastructure.mappers.MoodTrackerMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/moodTracker")
public class MoodTrackerController {
    private final MoodTrackerService moodTrackerService;

    public MoodTrackerController(MoodTrackerService moodTrackerService) {
        this.moodTrackerService = moodTrackerService;
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<MoodTrackerDto> getMoodTrackerDataByPatientId(@PathVariable Long patientId) {
        return ResponseEntity.ok(MoodTrackerMapper.toDto(moodTrackerService.findMoodTracker(patientId)));
    }

    @GetMapping
    public ResponseEntity<List<MoodTrackerDto>> getMoodTrackerData() {
        return ResponseEntity.ok(moodTrackerService.findAllMoodTrackers().stream()
                    .map(MoodTrackerMapper::toDto)
                    .collect(Collectors.toList())
                );
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<List<MoodTrackerDto>> getMoodTrackerDataByPatientIdAndEffectiveDate(
            @PathVariable Long patientId,
            @RequestParam String effectiveDate) {
        return ResponseEntity.ok(moodTrackerService.findAllMoodTrackersByPatientIdAndEffectiveDate(
                patientId, effectiveDate).stream()
                    .map(MoodTrackerMapper::toDto)
                    .collect(Collectors.toList())
                );
    }

    @PostMapping
    public ResponseEntity<MoodTrackerDto> createMoodTrackerData(@RequestBody MoodTrackerDto moodTrackerDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                MoodTrackerMapper.toDto(moodTrackerService.createMoodTracker(moodTrackerDto))
        );
    }
}
