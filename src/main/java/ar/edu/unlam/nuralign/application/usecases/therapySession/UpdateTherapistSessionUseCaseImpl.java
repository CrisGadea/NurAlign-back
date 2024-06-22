package ar.edu.unlam.nuralign.application.usecases.therapySession;

import ar.edu.unlam.nuralign.application.ports.in.therapySession.UpdateTherapistSessionUseCase;
import ar.edu.unlam.nuralign.application.ports.out.TherapySessionRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.TherapySession;

public class UpdateTherapistSessionUseCaseImpl implements UpdateTherapistSessionUseCase {
    private final TherapySessionRepositoryPort therapySessionRepositoryPort;

    public UpdateTherapistSessionUseCaseImpl(TherapySessionRepositoryPort therapySessionRepositoryPort) {
        this.therapySessionRepositoryPort = therapySessionRepositoryPort;
    }

    @Override
    public TherapySession update(Long sessionId, TherapySession therapySession) {
        return therapySessionRepositoryPort.save(therapySession);
    }
}
