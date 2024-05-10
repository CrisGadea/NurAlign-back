package ar.edu.unlam.nuralign.application.usecases.therapist;

import ar.edu.unlam.nuralign.application.ports.in.DeleteTherapistUseCase;
import ar.edu.unlam.nuralign.application.ports.out.TherapistRepositoryPort;

public class DeleteTherapistUseCaseImpl implements DeleteTherapistUseCase {

    private final TherapistRepositoryPort repository;

    public DeleteTherapistUseCaseImpl(TherapistRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public boolean deleteTherapist(Long id) {
        repository.deleteById(id);
        return false;
    }
}
