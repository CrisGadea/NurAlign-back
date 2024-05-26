package ar.edu.unlam.nuralign.application.usecases.medication;

import ar.edu.unlam.nuralign.application.ports.in.medication.FindAllMedicationsUseCase;
import ar.edu.unlam.nuralign.application.ports.out.MedicationRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.Medication;

import java.util.List;

public class FindAllMedicationsUseCaseImpl implements FindAllMedicationsUseCase {

    private final MedicationRepositoryPort repository;

    public FindAllMedicationsUseCaseImpl(MedicationRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public List<Medication> findAllMedications() {
        return repository.findAll();
    }
}
