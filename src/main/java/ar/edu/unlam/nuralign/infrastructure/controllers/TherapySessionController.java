package ar.edu.unlam.nuralign.infrastructure.controllers;


import ar.edu.unlam.nuralign.application.services.TherapySessionService;
import ar.edu.unlam.nuralign.domain.models.TherapySession;
import ar.edu.unlam.nuralign.infrastructure.dtos.TherapySessionDto;
import ar.edu.unlam.nuralign.infrastructure.mappers.TherapySessionMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/TherapySession")
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
            body(TherapySessionMapper.toDto(therapySessionService.createTherapySession(TherapySessionMapper.toModel(therapySessionDto)))
            );
}

}
