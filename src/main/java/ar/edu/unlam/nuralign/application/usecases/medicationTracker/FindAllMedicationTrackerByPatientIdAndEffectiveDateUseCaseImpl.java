package ar.edu.unlam.nuralign.application.usecases.medicationTracker;

import ar.edu.unlam.nuralign.application.ports.in.medicationTracker.FindAllMedicationTrackerByPatientIdAndEffectiveDateUseCase;
import ar.edu.unlam.nuralign.application.ports.out.MedicationTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.MedicationTracker;

import java.time.LocalDate;
import java.util.List;

public class FindAllMedicationTrackerByPatientIdAndEffectiveDateUseCaseImpl
        implements FindAllMedicationTrackerByPatientIdAndEffectiveDateUseCase {
    private final MedicationTrackerRepositoryPort medicationTrackerRepository;

    public FindAllMedicationTrackerByPatientIdAndEffectiveDateUseCaseImpl(MedicationTrackerRepositoryPort medicationTrackerRepository) {
        this.medicationTrackerRepository = medicationTrackerRepository;
    }

    @Override
    public List<MedicationTracker> findAllMedicationTrackerByPatientIdAndEffectiveDate(Long patientId, LocalDate effectiveDate) {
        return medicationTrackerRepository.findAllByPatientIdAndEffectiveDate(patientId, effectiveDate);
    }
}
