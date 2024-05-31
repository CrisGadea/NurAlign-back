package ar.edu.unlam.nuralign.application.usecases.therapySession;

import ar.edu.unlam.nuralign.application.ports.in.therapySession.FindAllTherapySessionByTherapistIdUseCase;
import ar.edu.unlam.nuralign.application.ports.out.TherapySessionRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.TherapySession;

import java.util.List;

public class FindAllTherapySessionByTherapistIdUseCaseImpl implements FindAllTherapySessionByTherapistIdUseCase {
    private TherapySessionRepositoryPort repository;
    public FindAllTherapySessionByTherapistIdUseCaseImpl(TherapySessionRepositoryPort repository)
    {
        this.repository = repository;


    }
    @Override
    public List<TherapySession> FindAllTherapySessionByTherapistId(Long therapistId) {
        return repository.findAllByTherapistId(therapistId);
    }
}
