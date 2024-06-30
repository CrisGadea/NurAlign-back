package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.application.services.MoodTrackerService;
import ar.edu.unlam.nuralign.domain.models.MoodTracker;
import ar.edu.unlam.nuralign.infrastructure.dtos.ApiResponse;
import ar.edu.unlam.nuralign.infrastructure.dtos.MoodTrackerDto;
import ar.edu.unlam.nuralign.infrastructure.exceptions.ResourceNotFoundException;
import ar.edu.unlam.nuralign.infrastructure.mappers.MoodTrackerMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/api/moodTracker")
@CrossOrigin (origins = "*")
public class MoodTrackerController {
    private final MoodTrackerService moodTrackerService;

    public MoodTrackerController(MoodTrackerService moodTrackerService) {
        this.moodTrackerService = moodTrackerService;
    }

    @GetMapping("/patientId/{patientId}")
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

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<MoodTrackerDto> getMoodTrackerDataByPatientIdAndEffectiveDate(
            @PathVariable Long patientId,
            @RequestParam("effectiveDate") String effectiveDate) {
        try {
            Optional<MoodTracker> tracker = moodTrackerService.findMoodTrackerByPatientIdAndEffectiveDate(
                    patientId, effectiveDate);
            return tracker.map(moodTracker -> ok(MoodTrackerMapper.toDto(moodTracker)))
                    .orElseGet(() -> noContent().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PostMapping
    public ResponseEntity<MoodTrackerDto> createMoodTrackerData(@RequestBody MoodTrackerDto moodTrackerDto) {
        return status(CREATED).body(
                MoodTrackerMapper.toDto(moodTrackerService.createMoodTracker(MoodTrackerMapper.toModel(moodTrackerDto)))
        );
    }

    @PatchMapping("/{patientId}")
    public ResponseEntity<MoodTrackerDto> updateMoodTrackerData(
            @PathVariable Long patientId,
            @RequestBody MoodTrackerDto moodTrackerDto,
            @RequestParam String effectiveDate) {
        return ok(MoodTrackerMapper.toDto(
                moodTrackerService.updateMoodTracker(
                        MoodTrackerMapper.toModel(moodTrackerDto), patientId, effectiveDate).get()
                )
        );
    }


    @GetMapping("/patients/{patientId}")
    public ResponseEntity<List<MoodTrackerDto>> getAllMoodTrackerDataByPatientId(@PathVariable Long patientId)
    {
        return  ResponseEntity.ok(moodTrackerService.findAllMoodTrackersByPatientId(patientId).stream()
                .map(MoodTrackerMapper::toDto).toList());
    }

    @GetMapping("patients/range/{patientId}")
    public ResponseEntity<List<MoodTrackerDto>> GetAllMoodTrackerByPatientIdAnRangeDate(@PathVariable Long patientId,
                                                                             @RequestParam String fromDate,
                                                                             @RequestParam String toDate)
    {
        LocalDate from = LocalDate.parse(fromDate);
        LocalDate to = LocalDate.parse(toDate);
        return ResponseEntity.ok(moodTrackerService.FindAllMoodTrackerByPatientIdAndRangeDate(patientId, from, to).stream().map(MoodTrackerMapper::toDto).toList());
    }

}
