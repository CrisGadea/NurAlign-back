package ar.edu.unlam.nuralign.application.usecases.medicationTracker;

import ar.edu.unlam.nuralign.application.ports.in.medicationTracker.FindAllMedicationTrackersUseCase;
import ar.edu.unlam.nuralign.application.ports.out.MedicationTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.MedicationTracker;

import java.util.List;

public class FindAllMedicationTrackersUseCaseImpl implements FindAllMedicationTrackersUseCase {
    private final MedicationTrackerRepositoryPort medicationTrackerRepositoryPort;

    public FindAllMedicationTrackersUseCaseImpl(MedicationTrackerRepositoryPort medicationTrackerRepositoryPort) {
        this.medicationTrackerRepositoryPort = medicationTrackerRepositoryPort;
    }

    @Override
    public List<MedicationTracker> findAllMedicationTrackers() {
        return medicationTrackerRepositoryPort.findAll();
    }
}
