package ar.edu.unlam.nuralign.application.ports.in.medicationTracker;

import ar.edu.unlam.nuralign.domain.models.MedicationTracker;

import java.util.List;

public interface FindAllMedicationTrackersUseCase {
    List<MedicationTracker> findAllMedicationTrackers();
}
