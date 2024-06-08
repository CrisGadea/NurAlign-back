package ar.edu.unlam.nuralign.application.usecases.medicationTracker;

import ar.edu.unlam.nuralign.application.ports.in.medicationTracker.FindMedicationTrackerUseCase;
import ar.edu.unlam.nuralign.application.ports.out.MedicationTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.MedicationTracker;

public class FindMedicationTrackerUseCaseImpl implements FindMedicationTrackerUseCase {
    private final MedicationTrackerRepositoryPort medicationTrackerRepositoryPort;

    public FindMedicationTrackerUseCaseImpl(MedicationTrackerRepositoryPort medicationTrackerRepositoryPort) {
        this.medicationTrackerRepositoryPort = medicationTrackerRepositoryPort;
    }

    @Override
    public MedicationTracker findMedicationTracker(Long id) {
        return medicationTrackerRepositoryPort.findById(id);
    }
}
