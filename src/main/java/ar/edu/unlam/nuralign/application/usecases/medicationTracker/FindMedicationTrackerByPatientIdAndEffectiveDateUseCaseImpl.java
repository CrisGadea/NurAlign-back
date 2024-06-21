package ar.edu.unlam.nuralign.application.usecases.medicationTracker;

import ar.edu.unlam.nuralign.application.ports.in.medicationTracker.FindMedicationTrackerByPatientIdAndEffectiveDateUseCase;
import ar.edu.unlam.nuralign.application.ports.out.MedicationTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.MedicationTracker;

import java.time.LocalDate;
import java.util.List;

public class FindMedicationTrackerByPatientIdAndEffectiveDateUseCaseImpl
        implements FindMedicationTrackerByPatientIdAndEffectiveDateUseCase {
    private final MedicationTrackerRepositoryPort medicationTrackerRepository;

    public FindMedicationTrackerByPatientIdAndEffectiveDateUseCaseImpl(MedicationTrackerRepositoryPort medicationTrackerRepository) {
        this.medicationTrackerRepository = medicationTrackerRepository;
    }

    @Override
    public MedicationTracker findMedicationTrackerByPatientIdAndEffectiveDate(Long patientId, LocalDate effectiveDate) {
        return medicationTrackerRepository.findByPatientIdAndEffectiveDate(patientId, effectiveDate);
    }
}
