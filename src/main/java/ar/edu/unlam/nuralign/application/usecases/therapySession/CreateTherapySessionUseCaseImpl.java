package ar.edu.unlam.nuralign.application.usecases.therapySession;

import ar.edu.unlam.nuralign.application.ports.in.therapySession.CreateTherapySessionUseCase;
import ar.edu.unlam.nuralign.application.ports.out.TherapySessionRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.TherapySession;

public class CreateTherapySessionUseCaseImpl implements CreateTherapySessionUseCase {

    private TherapySessionRepositoryPort repository;
    public CreateTherapySessionUseCaseImpl(TherapySessionRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public TherapySession createTherapySession(TherapySession therapySession) {

        return repository.save(therapySession);
    }
}
