package ar.edu.unlam.nuralign.application.ports.in.therapySession;

import ar.edu.unlam.nuralign.domain.models.TherapySession;

public interface FindTherapySessionByIdUseCase {

    TherapySession FindTherapySessionById(Long Id);
}
