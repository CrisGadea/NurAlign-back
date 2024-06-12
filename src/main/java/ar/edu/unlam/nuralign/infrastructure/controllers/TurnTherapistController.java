package ar.edu.unlam.nuralign.infrastructure.controllers;


import ar.edu.unlam.nuralign.application.services.TurnTherapistService;
import ar.edu.unlam.nuralign.domain.models.TurnTherapist;
import ar.edu.unlam.nuralign.infrastructure.dtos.TurnTherapistDto;
import ar.edu.unlam.nuralign.infrastructure.mappers.TurnTherapistMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/TurnTherapist")

@CrossOrigin(origins = "*")

public class TurnTherapistController {

    private final TurnTherapistService turnTherapistService;
    public TurnTherapistController(TurnTherapistService turnTherapistService) {
        this.turnTherapistService = turnTherapistService;
    }

    @PostMapping
    public ResponseEntity<TurnTherapistDto> create(@RequestBody TurnTherapistDto turnTherapistDto)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(TurnTherapistMapper.toDto(turnTherapistService.createTurnTherapist(TurnTherapistMapper.ToModel(turnTherapistDto))));
    }



    @GetMapping("/Therapist/{therapistId}")
    public ResponseEntity<List<TurnTherapist>> getAllByTherapistId(@PathVariable Long therapistId)
    {
        return ResponseEntity.ok(turnTherapistService.FindAllByTherapistId(therapistId));
    }

}
