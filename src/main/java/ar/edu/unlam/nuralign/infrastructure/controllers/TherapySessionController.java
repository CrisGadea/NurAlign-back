package ar.edu.unlam.nuralign.infrastructure.controllers;


import ar.edu.unlam.nuralign.application.services.TherapySessionService;
import ar.edu.unlam.nuralign.domain.models.TherapySession;
import ar.edu.unlam.nuralign.infrastructure.dtos.TherapySessionDto;
import ar.edu.unlam.nuralign.infrastructure.mappers.TherapySessionMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/therapySession")
@CrossOrigin (origins = "*")
public class TherapySessionController {

    private final TherapySessionService therapySessionService;

    public TherapySessionController(TherapySessionService therapySessionService) {
        this.therapySessionService = therapySessionService;
    }

    @PostMapping
        public ResponseEntity<TherapySessionDto> createTherapySession(@RequestBody TherapySessionDto therapySessionDto)
    {
        return ResponseEntity.status(HttpStatus.CREATED).
                body(TherapySessionMapper.toDto(therapySessionService.createTherapySession(
                        TherapySessionMapper.toModel(therapySessionDto)))
                );
    }

    @GetMapping("/{id}")
    public ResponseEntity<TherapySessionDto> getTherapySessionById(@PathVariable Long id)
    {
        return ResponseEntity.ok(TherapySessionMapper.toDto(therapySessionService.FindTherapySessionById(id)));
    }

    @GetMapping("/patient/{patientId}")
        public ResponseEntity<List<TherapySession>> getAllTherapySessionByPatientId(@PathVariable Long patientId)
        {
    return ResponseEntity.ok(therapySessionService.FindAllTherapySessionByPatientId(patientId));

        }


    @GetMapping("/therapist/{therapistId}")
    public ResponseEntity<List<TherapySession>> getAllTherapySessionByTherapistId(@PathVariable Long therapistId)
    {
        return ResponseEntity.ok(therapySessionService.FindAllTherapySessionByTherapistId(therapistId));

    }

    @GetMapping("/patient/{patientId}/therapist/{therapistId}")
    public ResponseEntity<List<TherapySession>> getAllTherapySessionByPatientIdAndTherapistId(
            @PathVariable Long patientId,
            @PathVariable Long therapistId)
    {
        return ResponseEntity.ok(therapySessionService.findAllTherapySessionsByPatientIdAndTherapistId(patientId, therapistId));
    }


    @PatchMapping("/patient/{patientId}")
    public ResponseEntity<TherapySessionDto> updateTherapySession(
            @PathVariable Long patientId,
            @RequestBody TherapySessionDto therapySession,
            @RequestParam Long therapistId,
            @RequestParam String effectiveDate)
    {
        TherapySession session = therapySessionService.update(
                TherapySessionMapper.toModel(therapySession),
                patientId,
                therapistId,
                LocalDate.parse(effectiveDate)
        );
        return session == null ? ResponseEntity.notFound().build() :
                ResponseEntity.ok(TherapySessionMapper.toDto(session));
    }


    @GetMapping("patients/range/{patientId}")
    public  ResponseEntity<List<TherapySessionDto>>findAllTherapySessionByPatientIdRangeDate(@PathVariable Long patientId,
                                                                                      @RequestParam String fromDate,
                                                                                      @RequestParam String toDate)
    {
      /*  LocalDate from = LocalDate.parse(fromDate);
        LocalDate to = LocalDate.parse(toDate);*/
        return ResponseEntity.ok(therapySessionService.FindAllTherapySessionByPatientIdAndRangeDate(patientId,fromDate,toDate).stream().map(TherapySessionMapper::toDto).toList());
    }


}
