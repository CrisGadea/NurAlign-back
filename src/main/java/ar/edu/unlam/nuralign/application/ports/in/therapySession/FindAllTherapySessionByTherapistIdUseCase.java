package ar.edu.unlam.nuralign.application.ports.in.therapySession;

import ar.edu.unlam.nuralign.domain.models.TherapySession;

import java.util.List;

public interface FindAllTherapySessionByTherapistIdUseCase {

   List<TherapySession> FindAllTherapySessionByTherapistId(Long id);
}
