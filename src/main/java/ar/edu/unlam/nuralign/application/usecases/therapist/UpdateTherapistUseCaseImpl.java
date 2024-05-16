package ar.edu.unlam.nuralign.application.usecases.therapist;

import ar.edu.unlam.nuralign.application.ports.in.therapist.UpdateTherapistUseCase;
import ar.edu.unlam.nuralign.application.ports.out.TherapistRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.Therapist;

import java.util.Optional;

public class UpdateTherapistUseCaseImpl implements UpdateTherapistUseCase {

    private final TherapistRepositoryPort repository;

    public UpdateTherapistUseCaseImpl(TherapistRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Therapist> updateTherapist(Therapist therapist, Long therapistId) {
        return repository.update(therapist, therapistId);
    }
}
