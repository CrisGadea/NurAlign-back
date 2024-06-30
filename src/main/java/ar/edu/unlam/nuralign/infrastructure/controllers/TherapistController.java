package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.application.services.LoginTherapistService;
import ar.edu.unlam.nuralign.domain.models.Therapist;
import ar.edu.unlam.nuralign.infrastructure.config.JwtTokenProvider;
import ar.edu.unlam.nuralign.infrastructure.dtos.LoginData;
import ar.edu.unlam.nuralign.infrastructure.dtos.LoginResponse;
import ar.edu.unlam.nuralign.infrastructure.dtos.TherapistDto;
import ar.edu.unlam.nuralign.infrastructure.mappers.TherapistMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.edu.unlam.nuralign.application.services.TherapistService;

import java.util.List;

@RestController
@RequestMapping("/api/therapists")
@CrossOrigin(origins = "*")
public class TherapistController {

    private final TherapistService therapistService;

    private final LoginTherapistService loginService;

    private final JwtTokenProvider jwtTokenProvider;

    public TherapistController(TherapistService therapistService,
                               LoginTherapistService loginService,
                               JwtTokenProvider jwtTokenProvider) {
        this.therapistService = therapistService;
        this.loginService = loginService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping
    public ResponseEntity<TherapistDto> createTherapist(@RequestBody TherapistDto therapist) {
        Therapist newTherapist = therapistService.createTherapist(
                TherapistMapper.mapToDomain(therapist)
        );
        if (newTherapist == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(TherapistMapper.mapToDto(newTherapist));
    }

    @GetMapping("/{therapistId}")
    public ResponseEntity<Therapist> findTherapist(@PathVariable Long therapistId) {
        return therapistService.findTherapist(therapistId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Therapist>> findAllTherapists() {
        return ResponseEntity.ok(therapistService.findAllTherapists());
    }

    @PatchMapping("/{therapistId}")
    public ResponseEntity<Therapist> updateTherapist(@RequestBody Therapist therapist,
                                                               @PathVariable Long therapistId) {
        return therapistService.updateTherapist(therapist, therapistId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{therapistId}")
    public ResponseEntity<Void> deleteTherapist(@PathVariable Long therapistId) {
        return therapistService.deleteTherapist(therapistId) ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginData user) {
        Therapist therapist = loginService.login(user);
        String token = jwtTokenProvider.generateToken(therapist);
        return ResponseEntity.ok(LoginResponse.builder().token(token).build());
    }

}
