package ar.edu.unlam.nuralign.application.usecases.medication;

import ar.edu.unlam.nuralign.application.ports.in.medication.DeleteMedicationUseCase;
import ar.edu.unlam.nuralign.application.ports.out.MedicationRepositoryPort;

public class DeleteMedicationUseCaseImpl implements DeleteMedicationUseCase {

    private final MedicationRepositoryPort medicationRepository;

    public DeleteMedicationUseCaseImpl(MedicationRepositoryPort medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    @Override
    public void deleteMedication(Long id) {
        medicationRepository.deleteMedication(id);
    }
}
