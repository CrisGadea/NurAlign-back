package ar.edu.unlam.nuralign.application.usecases.therapySession;

import ar.edu.unlam.nuralign.application.ports.in.therapySession.FindAllTherapySessionByPatientIdAndRangeDateUseCase;
import ar.edu.unlam.nuralign.application.ports.out.TherapySessionRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.TherapySession;

import java.util.List;

public class FindAllTherapySessionByPatientIdAndRangeDateUseCaseImpl implements FindAllTherapySessionByPatientIdAndRangeDateUseCase {
    private final TherapySessionRepositoryPort therapySessionRepository;

    public FindAllTherapySessionByPatientIdAndRangeDateUseCaseImpl(TherapySessionRepositoryPort therapySessionRepository) {
        this.therapySessionRepository = therapySessionRepository;
    }

    @Override
    public List<TherapySession> FindAllTherapySessionByPatientIdAndRangeDate(Long patientId, String fromDate, String toDate) {
        return therapySessionRepository.findAllTherapySessionByPatientIdAndRangeDate(patientId, fromDate, toDate);
    }
}
