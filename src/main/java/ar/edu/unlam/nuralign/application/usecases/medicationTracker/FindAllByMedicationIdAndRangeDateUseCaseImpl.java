package ar.edu.unlam.nuralign.application.usecases.medicationTracker;

import ar.edu.unlam.nuralign.application.ports.in.medicationTracker.FindAllByMedicationIdAndRangeDateUseCase;
import ar.edu.unlam.nuralign.application.ports.out.MedicationTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.MedicationTracker;

import java.time.LocalDate;
import java.util.List;

public class FindAllByMedicationIdAndRangeDateUseCaseImpl implements FindAllByMedicationIdAndRangeDateUseCase {

    private final MedicationTrackerRepositoryPort medicationTrackerRepositoryPort;

    public FindAllByMedicationIdAndRangeDateUseCaseImpl(MedicationTrackerRepositoryPort medicationTrackerRepositoryPort) {
        this.medicationTrackerRepositoryPort = medicationTrackerRepositoryPort;
    }

    @Override
    public List<MedicationTracker> findAllByMedicationIdAndRangeDate(Long patientId, LocalDate fromDate, LocalDate toDate) {
        return medicationTrackerRepositoryPort.findAllByMedicationIdAndRangeDate(patientId, fromDate, toDate);
    }
}
