package ar.edu.unlam.nuralign.application.usecases.therapist;

import ar.edu.unlam.nuralign.application.ports.in.FindTherapistUseCase;
import ar.edu.unlam.nuralign.application.ports.out.TherapistRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.Therapist;

import java.util.Optional;

public class FindTherapistUseCaseImpl implements FindTherapistUseCase {

    private final TherapistRepositoryPort repository;

    public FindTherapistUseCaseImpl(TherapistRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Therapist> findTherapist(Long id) {
        return repository.findById(id);
    }
}
