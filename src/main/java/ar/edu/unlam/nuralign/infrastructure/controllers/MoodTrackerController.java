package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.application.services.MoodTrackerService;
import ar.edu.unlam.nuralign.infrastructure.dtos.MoodTrackerDto;
import ar.edu.unlam.nuralign.infrastructure.mappers.MoodTrackerMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/api/moodTracker")
public class MoodTrackerController {
    private final MoodTrackerService moodTrackerService;

    public MoodTrackerController(MoodTrackerService moodTrackerService) {
        this.moodTrackerService = moodTrackerService;
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<MoodTrackerDto> getMoodTrackerDataByPatientId(@PathVariable Long patientId) {
        return ok(MoodTrackerMapper.toDto(moodTrackerService.findMoodTracker(patientId)));
    }

    @GetMapping
    public ResponseEntity<List<MoodTrackerDto>> getMoodTrackerData() {
        return ok(moodTrackerService.findAllMoodTrackers().stream()
                    .map(MoodTrackerMapper::toDto)
                    .collect(toList())
                );
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<MoodTrackerDto> getMoodTrackerDataByPatientIdAndEffectiveDate(
            @PathVariable Long patientId,
            @RequestParam String effectiveDate) {
        return ok(MoodTrackerMapper.toDto(moodTrackerService.findMoodTrackerByPatientIdAndEffectiveDate(
                patientId, effectiveDate))
                );
    }

    @PostMapping
    public ResponseEntity<MoodTrackerDto> createMoodTrackerData(@RequestBody MoodTrackerDto moodTrackerDto) {
        return status(CREATED).body(
                MoodTrackerMapper.toDto(moodTrackerService.createMoodTracker(moodTrackerDto))
        );
    }

    @PatchMapping("/{patientId}")
    public ResponseEntity<MoodTrackerDto> updateMoodTrackerData(
            @PathVariable Long patientId,
            @RequestBody MoodTrackerDto moodTrackerDto,
            @RequestParam LocalDate effectiveDate) {
        return ok(MoodTrackerMapper.toDto(
                moodTrackerService.updateMoodTracker(
                        MoodTrackerMapper.toModel(moodTrackerDto), patientId, effectiveDate).get()
                )
        );
    }
}
