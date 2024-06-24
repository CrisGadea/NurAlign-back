package ar.edu.unlam.nuralign.application.ports.in.therapySession;

import ar.edu.unlam.nuralign.domain.models.TherapySession;

import java.time.LocalDate;

public interface UpdateTherapistSessionUseCase {
    TherapySession update(TherapySession therapySession, Long patientId, Long therapistId, LocalDate effectiveDate);
}
