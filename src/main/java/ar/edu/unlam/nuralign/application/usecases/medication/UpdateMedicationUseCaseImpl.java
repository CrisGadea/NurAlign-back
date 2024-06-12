package ar.edu.unlam.nuralign.application.usecases.medication;

import ar.edu.unlam.nuralign.application.ports.in.medication.UpdateMedicationUseCase;
import ar.edu.unlam.nuralign.application.ports.out.MedicationRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.Medication;

import java.util.Optional;

public class UpdateMedicationUseCaseImpl implements UpdateMedicationUseCase {

    private final MedicationRepositoryPort medicationRepository;

    public UpdateMedicationUseCaseImpl(MedicationRepositoryPort medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    @Override
    public Optional<Medication> updateMedication(Medication medication, Long patientId) {
        return medicationRepository.updateMedication(medication, patientId);
    }
}
