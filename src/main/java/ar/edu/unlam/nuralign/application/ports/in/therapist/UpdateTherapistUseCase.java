package ar.edu.unlam.nuralign.application.ports.in.therapist;

import ar.edu.unlam.nuralign.domain.models.Therapist;

import java.util.Optional;

public interface UpdateTherapistUseCase {
    Optional<Therapist> updateTherapist(Therapist therapist, Long therapistId);
}
