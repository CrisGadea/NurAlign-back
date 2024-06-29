package ar.edu.unlam.nuralign.application.ports.in.therapySession;

import ar.edu.unlam.nuralign.domain.models.TherapySession;

import java.util.List;

public interface FindAllTherapySessionByPatientIdAndRangeDateUseCase {


    List<TherapySession> FindAllTherapySessionByPatientIdAndRangeDate(Long patientId, String fromDate, String toDate);
}
