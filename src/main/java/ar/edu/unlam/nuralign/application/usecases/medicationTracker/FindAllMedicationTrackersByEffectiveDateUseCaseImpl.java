package ar.edu.unlam.nuralign.application.usecases.medicationTracker;

import ar.edu.unlam.nuralign.application.ports.in.medicationTracker.FindAllMedicationTrackersByEffectiveDateUseCase;
import ar.edu.unlam.nuralign.application.ports.out.MedicationTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.MedicationTracker;

import java.time.LocalDate;
import java.util.List;

public class FindAllMedicationTrackersByEffectiveDateUseCaseImpl implements FindAllMedicationTrackersByEffectiveDateUseCase {

    private final MedicationTrackerRepositoryPort medicationTrackerRepositoryPort;

    public FindAllMedicationTrackersByEffectiveDateUseCaseImpl(MedicationTrackerRepositoryPort medicationTrackerRepositoryPort) {
        this.medicationTrackerRepositoryPort = medicationTrackerRepositoryPort;
    }

    @Override
    public List<MedicationTracker> findAllMedicationTrackersByEffectiveDate(String effectiveDate) {
        return medicationTrackerRepositoryPort.findAllByEffectiveDate(LocalDate.parse(effectiveDate));
    }
}
