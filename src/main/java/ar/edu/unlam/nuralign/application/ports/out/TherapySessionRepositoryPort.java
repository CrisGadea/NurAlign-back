package ar.edu.unlam.nuralign.application.ports.out;

import ar.edu.unlam.nuralign.domain.models.TherapySession;

import java.time.LocalDate;
import java.util.List;

public interface TherapySessionRepositoryPort {
    TherapySession save(TherapySession therapySession);
    List<TherapySession> findAllByPatientId(Long patientId);
    List<TherapySession> findAllByTherapistId(Long therapistId);
    TherapySession findBySessionId(Long sessionId);
    List<TherapySession> findAllByPatientIdAndTherapistId(Long patientId, Long therapistId);
    List<TherapySession> findAll();
    TherapySession update(TherapySession therapySession,Long patientId, Long therapistId, LocalDate effectiveDate);
}
