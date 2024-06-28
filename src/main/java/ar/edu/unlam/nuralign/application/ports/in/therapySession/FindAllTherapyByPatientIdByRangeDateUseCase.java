package ar.edu.unlam.nuralign.application.ports.in.therapySession;

import ar.edu.unlam.nuralign.domain.models.TherapySession;

import java.time.LocalDate;
import java.util.List;

public interface FindAllTherapyByPatientIdByRangeDateUseCase {


    List<TherapySession>FindAllTherapyByPatientIdByRangeDate(Long patientId, String fromDate, String toDate);
}
