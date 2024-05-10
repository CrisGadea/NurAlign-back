package ar.edu.unlam.nuralign.application.ports.in;

import ar.edu.unlam.nuralign.domain.models.Therapist;

import java.util.Optional;

public interface FindTherapistUseCase {
    Optional<Therapist> findTherapist(Long id);
}
