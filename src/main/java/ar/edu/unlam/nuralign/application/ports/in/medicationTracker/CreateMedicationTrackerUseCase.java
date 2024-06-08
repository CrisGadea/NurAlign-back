package ar.edu.unlam.nuralign.application.ports.in.medicationTracker;

import ar.edu.unlam.nuralign.domain.models.MedicationTracker;
import ar.edu.unlam.nuralign.infrastructure.dtos.MedicationTrackerDto;

public interface CreateMedicationTrackerUseCase {
    MedicationTracker createMedicationTracker(MedicationTrackerDto medicationTracker);
}
