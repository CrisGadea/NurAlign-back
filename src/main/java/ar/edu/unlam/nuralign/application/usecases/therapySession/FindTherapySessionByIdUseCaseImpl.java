package ar.edu.unlam.nuralign.application.usecases.therapySession;

import ar.edu.unlam.nuralign.application.ports.in.therapySession.FindTherapySessionByIdUseCase;
import ar.edu.unlam.nuralign.application.ports.out.TherapySessionRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.TherapySession;

public class FindTherapySessionByIdUseCaseImpl implements FindTherapySessionByIdUseCase {

    private final TherapySessionRepositoryPort repository;
    public FindTherapySessionByIdUseCaseImpl(TherapySessionRepositoryPort repository)
    {
        this.repository = repository;
    }
    @Override
    public TherapySession FindTherapySessionById(Long Id) {
        return repository.findById(Id);
    }
}
