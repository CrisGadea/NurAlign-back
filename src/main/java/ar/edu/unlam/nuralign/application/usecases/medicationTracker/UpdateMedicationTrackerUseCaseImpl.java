package ar.edu.unlam.nuralign.application.usecases.medicationTracker;

import ar.edu.unlam.nuralign.application.ports.in.medicationTracker.UpdateMedicationTrackerUseCase;
import ar.edu.unlam.nuralign.application.ports.out.MedicationTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.MedicationTracker;

import java.time.LocalDate;
import java.util.Optional;

public class UpdateMedicationTrackerUseCaseImpl implements UpdateMedicationTrackerUseCase {

    private final MedicationTrackerRepositoryPort medicationTrackerRepository;

    public UpdateMedicationTrackerUseCaseImpl(MedicationTrackerRepositoryPort medicationTrackerRepository) {
        this.medicationTrackerRepository = medicationTrackerRepository;
    }

    @Override
    public Optional<MedicationTracker> update(MedicationTracker medicationTracker, Long patientId, String effectiveDate) {
        return medicationTrackerRepository.update(medicationTracker, patientId, LocalDate.parse(effectiveDate));
    }


}
