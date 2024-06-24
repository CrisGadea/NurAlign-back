package ar.edu.unlam.nuralign.application.usecases.therapySession;

import ar.edu.unlam.nuralign.application.ports.in.therapySession.FindAllTherapySessionsByPatientIdAndTherapistIdUseCase;
import ar.edu.unlam.nuralign.application.ports.out.TherapySessionRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.TherapySession;

import java.util.List;

public class FindAllTherapySessionsByPatientIdAndTherapistIdUseCaseImpl implements FindAllTherapySessionsByPatientIdAndTherapistIdUseCase {
    private final TherapySessionRepositoryPort therapySessionRepository;

    public FindAllTherapySessionsByPatientIdAndTherapistIdUseCaseImpl(TherapySessionRepositoryPort therapySessionRepository) {
        this.therapySessionRepository = therapySessionRepository;
    }

    @Override
    public List<TherapySession> findAllTherapySessionsByPatientIdAndTherapistId(Long patientId, Long therapistId) {
        return therapySessionRepository.findAllByPatientIdAndTherapistId(patientId, therapistId);
    }
}
