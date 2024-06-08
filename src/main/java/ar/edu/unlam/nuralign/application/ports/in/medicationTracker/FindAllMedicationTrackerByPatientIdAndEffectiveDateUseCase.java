package ar.edu.unlam.nuralign.application.ports.in.medicationTracker;

import ar.edu.unlam.nuralign.domain.models.MedicationTracker;

import java.time.LocalDate;
import java.util.List;

public interface FindAllMedicationTrackerByPatientIdAndEffectiveDateUseCase {
    List<MedicationTracker> findAllMedicationTrackerByPatientIdAndEffectiveDate(Long patientId, LocalDate effectiveDate);
}
