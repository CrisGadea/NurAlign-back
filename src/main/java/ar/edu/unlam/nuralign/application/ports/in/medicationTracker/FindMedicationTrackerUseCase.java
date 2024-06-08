package ar.edu.unlam.nuralign.application.ports.in.medicationTracker;

import ar.edu.unlam.nuralign.domain.models.MedicationTracker;

public interface FindMedicationTrackerUseCase {
    MedicationTracker findMedicationTracker(Long id);
}
