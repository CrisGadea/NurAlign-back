package ar.edu.unlam.nuralign.application.usecases.medication;

import ar.edu.unlam.nuralign.application.ports.in.medication.FindMedicationUseCase;
import ar.edu.unlam.nuralign.application.ports.out.MedicationRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.Medication;

public class FindMedicationUseCaseImpl implements FindMedicationUseCase {

    private final MedicationRepositoryPort repository;

    public FindMedicationUseCaseImpl(MedicationRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Medication findMedication(Long id) {
        return repository.findById(id);
    }

}
