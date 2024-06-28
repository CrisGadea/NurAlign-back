package ar.edu.unlam.nuralign.application.usecases.therapySession;

import ar.edu.unlam.nuralign.application.ports.in.therapySession.FindAllTherapyByPatientIdByRangeDateUseCase;
import ar.edu.unlam.nuralign.application.ports.out.TherapySessionRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.TherapySession;

import java.time.LocalDate;
import java.util.List;

public class FindAllTherapyByPatientIdByRangeDateUseCaseImpl implements FindAllTherapyByPatientIdByRangeDateUseCase {
    private final TherapySessionRepositoryPort therapySessionRepository;

    public FindAllTherapyByPatientIdByRangeDateUseCaseImpl(TherapySessionRepositoryPort therapySessionRepository) {
        this.therapySessionRepository = therapySessionRepository;
    }

    @Override
    public List<TherapySession> FindAllTherapyByPatientIdByRangeDate(Long patientId, String fromDate, String toDate) {
        return therapySessionRepository.findAllByPatientIdByRangeDate(patientId, fromDate, toDate);
    }
}
