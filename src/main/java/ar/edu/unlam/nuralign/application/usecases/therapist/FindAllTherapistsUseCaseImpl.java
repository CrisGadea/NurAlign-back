package ar.edu.unlam.nuralign.application.usecases.therapist;

import ar.edu.unlam.nuralign.application.ports.in.FindAllTherapistsUseCase;
import ar.edu.unlam.nuralign.application.ports.out.TherapistRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.Therapist;

import java.util.List;

public class FindAllTherapistsUseCaseImpl implements FindAllTherapistsUseCase {

    private final TherapistRepositoryPort repository;

    public FindAllTherapistsUseCaseImpl(TherapistRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public List<Therapist> findAllTherapists() {
        return repository.findAll();
    }

}
