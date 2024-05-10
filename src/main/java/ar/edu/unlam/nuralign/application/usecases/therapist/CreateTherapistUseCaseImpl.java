package ar.edu.unlam.nuralign.application.usecases.therapist;

import ar.edu.unlam.nuralign.application.ports.in.CreateTherapistUseCase;
import ar.edu.unlam.nuralign.application.ports.out.TherapistRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.Therapist;

public class CreateTherapistUseCaseImpl implements CreateTherapistUseCase {

    private final TherapistRepositoryPort repository;

    public CreateTherapistUseCaseImpl(TherapistRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Therapist createTherapist(Therapist therapist) {
        return repository.save(therapist);
    }

}
