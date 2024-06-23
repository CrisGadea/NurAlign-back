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
    public ResponseEntity<?> getMoodTrackerDataByPatientIdAndEffectiveDate(
            @PathVariable Long patientId,
            @RequestParam("effectiveDate") String effectiveDate) {
        try {
            Optional<MoodTracker> tracker = moodTrackerService.findMoodTrackerByPatientIdAndEffectiveDate(patientId, effectiveDate);
            if (tracker.isPresent()) {
                return ok(MoodTrackerMapper.toDto(tracker.get()));
            } else {
                throw new ResourceNotFoundException("El paciente solicitado no tiene ningún tracker completo para esa fecha dada");
            }
        }  catch (ResourceNotFoundException e) {
            return ResponseEntity.noContent().build();
            //ApiResponse response = new ApiResponse(e.getMessage(), 204, "accepted");
            //return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        } catch (Exception e) {
            ApiResponse response = new ApiResponse("Error interno del servidor", 500, "error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

        }
////        if (tracker.isPresent()) {
////            return new ResponseEntity<>(MoodTrackerMapper.toDto(tracker.get()), HttpStatus.OK);
////        } else {
////            throw new ResourceNotFoundException("El paciente solicitado no tiene ningún tracker completo para esa fecha dada");
////        }
//
//        if (tracker.isPresent()) {
//            return new ResponseEntity<>(MoodTrackerMapper.toDto(tracker.get()), HttpStatus.OK);
//        } else {
//            ApiResponse response = new ApiResponse(
//                    "El paciente solicitado no tiene ningún tracker completo para esa fecha dada",
//                    204,
//                    "accepted");
//            return ResponseEntity.noContent().build();
            //return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
  //      }
    //}

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
            @RequestParam String effectiveDate) {
        return ok(MoodTrackerMapper.toDto(
                moodTrackerService.updateMoodTracker(
                        MoodTrackerMapper.toModel(moodTrackerDto), patientId, effectiveDate).get()
                )
        );
    }
}
