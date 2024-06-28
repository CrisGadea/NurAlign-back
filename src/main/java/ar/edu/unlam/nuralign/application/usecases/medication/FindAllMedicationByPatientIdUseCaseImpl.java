package ar.edu.unlam.nuralign.application.usecases.medication;

import ar.edu.unlam.nuralign.application.ports.in.medication.FindAllMedicationByPatientIdUseCase;
import ar.edu.unlam.nuralign.application.ports.out.MedicationRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.Medication;

import java.time.LocalDate;
import java.util.List;

public class FindAllMedicationByPatientIdUseCaseImpl implements FindAllMedicationByPatientIdUseCase {
    private final MedicationRepositoryPort medicationRepositoryPort;

    public FindAllMedicationByPatientIdUseCaseImpl(MedicationRepositoryPort medicationRepositoryPort) {
        this.medicationRepositoryPort = medicationRepositoryPort;
    }

    @Override
    public List<Medication> findAllMedicationByPatientId(Long patientId, LocalDate fromDate, LocalDate toDate, Character takenFlag) {
        return medicationRepositoryPort.findAllMedicationByPatientId( patientId, fromDate, toDate, takenFlag);
    }
}
