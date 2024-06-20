package ar.edu.unlam.nuralign.application.ports.in.medicationTracker;

import ar.edu.unlam.nuralign.domain.models.MedicationTracker;

import java.util.Optional;

public interface UpdateMedicationTrackerUseCase {
    Optional<MedicationTracker> update(MedicationTracker medicationTracker, Long patientId, String effectiveDate);
}
