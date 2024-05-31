package ar.edu.unlam.nuralign.application.ports.out;

import ar.edu.unlam.nuralign.domain.models.TherapySession;

import java.util.List;

public interface TherapySessionRepositoryPort {

    TherapySession save(TherapySession therapySession);
   List<TherapySession> findAllByPatientId(Long patientId);
   List<TherapySession> findAllByTherapistId(Long therapistId);
    TherapySession findBySessionId(Long sessionId);
    List<TherapySession> findAll();

}
