package ar.edu.unlam.nuralign.application.usecases.medicationTracker;

import ar.edu.unlam.nuralign.application.ports.in.medicationTracker.FindAllMedicationTrackersByPatientIdUseCase;
import ar.edu.unlam.nuralign.application.ports.out.MedicationTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.MedicationTracker;

import java.util.List;

public class FindAllMedicationTrackersByPatientIdUseCaseImpl implements FindAllMedicationTrackersByPatientIdUseCase {

    private final MedicationTrackerRepositoryPort medicationTrackerRepositoryPort;

    public FindAllMedicationTrackersByPatientIdUseCaseImpl(MedicationTrackerRepositoryPort medicationTrackerRepositoryPort) {
        this.medicationTrackerRepositoryPort = medicationTrackerRepositoryPort;
    }

    @Override
    public List<MedicationTracker> findAllMedicationTrackersByPatientId(Long patientId) {
        return medicationTrackerRepositoryPort.findAllByPatientId(patientId);
    }
}
