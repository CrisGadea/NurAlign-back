package ar.edu.unlam.nuralign.application.usecases.medication;

import ar.edu.unlam.nuralign.application.ports.in.medication.CreateMedicationUseCase;
import ar.edu.unlam.nuralign.application.ports.out.MedicationRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.Medication;

public class CreateMedicationUseCaseImpl implements CreateMedicationUseCase {

    private final MedicationRepositoryPort repository;

    public CreateMedicationUseCaseImpl(MedicationRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Medication createMedication(Medication medication) {
        return repository.save(medication);
    }
}
