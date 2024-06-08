package ar.edu.unlam.nuralign.application.usecases.medicationTracker;

import ar.edu.unlam.nuralign.application.ports.in.medicationTracker.CreateMedicationTrackerUseCase;
import ar.edu.unlam.nuralign.application.ports.out.MedicationTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.MedicationTracker;
import ar.edu.unlam.nuralign.infrastructure.dtos.MedicationTrackerDto;
import ar.edu.unlam.nuralign.infrastructure.mappers.MedicationTrackerMapper;

public class CreateMedicationTrackerUseCaseImpl implements CreateMedicationTrackerUseCase {

    private final MedicationTrackerRepositoryPort medicationTrackerRepositoryPort;

    public CreateMedicationTrackerUseCaseImpl(MedicationTrackerRepositoryPort medicationTrackerRepositoryPort) {
        this.medicationTrackerRepositoryPort = medicationTrackerRepositoryPort;
    }

    @Override
    public MedicationTracker createMedicationTracker(MedicationTrackerDto medicationTracker) {
        return medicationTrackerRepositoryPort.save(MedicationTrackerMapper.toModel(medicationTracker));
    }
}
