package ar.edu.unlam.nuralign.application.usecases.therapySession;

import ar.edu.unlam.nuralign.application.ports.in.therapySession.FindAllTherapySessionByPatientIdUseCase;
import ar.edu.unlam.nuralign.application.ports.out.TherapySessionRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.TherapySession;

import java.util.List;

public class FindAllTherapySessionByPatientIdUseCaseImpl implements FindAllTherapySessionByPatientIdUseCase {
    private TherapySessionRepositoryPort repository;
    public FindAllTherapySessionByPatientIdUseCaseImpl(TherapySessionRepositoryPort repository) {

        this.repository = repository;

    }
    @Override
    public List<TherapySession> FindAllTherapySessionByPatientId(Long id) {
        return repository.findAllByPatientId(id);
    }
}



