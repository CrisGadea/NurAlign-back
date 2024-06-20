package ar.edu.unlam.nuralign.application.usecases.medicationTracker;

import ar.edu.unlam.nuralign.application.ports.in.medicationTracker.FindMedicationTrackerByEffectiveDateUseCase;
import ar.edu.unlam.nuralign.application.ports.out.MedicationTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.MedicationTracker;

import java.time.LocalDate;
import java.util.List;

public class FindMedicationTrackerByEffectiveDateUseCaseImpl implements FindMedicationTrackerByEffectiveDateUseCase {

    private final MedicationTrackerRepositoryPort medicationTrackerRepositoryPort;

    public FindMedicationTrackerByEffectiveDateUseCaseImpl(MedicationTrackerRepositoryPort medicationTrackerRepositoryPort) {
        this.medicationTrackerRepositoryPort = medicationTrackerRepositoryPort;
    }

    @Override
    public MedicationTracker findMedicationTrackerByEffectiveDate(String effectiveDate) {
        return medicationTrackerRepositoryPort.findByEffectiveDate(LocalDate.parse(effectiveDate));
    }
}
