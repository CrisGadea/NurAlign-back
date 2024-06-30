package ar.edu.unlam.nuralign.application.usecases.medicationTracker;

import ar.edu.unlam.nuralign.application.ports.in.medicationTracker.CreateMedicationTrackerUseCase;
import ar.edu.unlam.nuralign.application.ports.out.MedicationTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.MedicationTracker;

public class CreateMedicationTrackerUseCaseImpl implements CreateMedicationTrackerUseCase {

    private final MedicationTrackerRepositoryPort medicationTrackerRepositoryPort;

    public CreateMedicationTrackerUseCaseImpl(MedicationTrackerRepositoryPort medicationTrackerRepositoryPort) {
        this.medicationTrackerRepositoryPort = medicationTrackerRepositoryPort;
    }

    @Override
    public MedicationTracker createMedicationTracker(MedicationTracker medicationTracker) {
        return medicationTrackerRepositoryPort.save(medicationTracker);
    }
}
