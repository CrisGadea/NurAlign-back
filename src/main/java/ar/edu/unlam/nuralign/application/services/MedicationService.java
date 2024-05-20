package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.medication.CreateMedicationUseCase;
import ar.edu.unlam.nuralign.application.ports.in.medication.FindAllMedicationsUseCase;
import ar.edu.unlam.nuralign.application.ports.in.medication.FindMedicationUseCase;
import ar.edu.unlam.nuralign.domain.models.Medication;

import java.util.List;

public class MedicationService implements CreateMedicationUseCase, FindMedicationUseCase, FindAllMedicationsUseCase {

    private final CreateMedicationUseCase createMedicationUseCase;
    private final FindMedicationUseCase findMedicationUseCase;
    private final FindAllMedicationsUseCase findAllMedicationsUseCase;

    public MedicationService(CreateMedicationUseCase createMedicationUseCase, FindMedicationUseCase findMedicationUseCase,
                             FindAllMedicationsUseCase findAllMedicationsUseCase) {
        this.createMedicationUseCase = createMedicationUseCase;
        this.findMedicationUseCase = findMedicationUseCase;
        this.findAllMedicationsUseCase = findAllMedicationsUseCase;
    }

    @Override
    public Medication createMedication(Medication medication){
        return createMedicationUseCase.createMedication(medication);
    }

    @Override
    public Medication findMedication(Long id) {
        return findMedicationUseCase.findMedication(id);
    }

    @Override
    public List<Medication> findAllMedications() {
        return findAllMedicationsUseCase.findAllMedications();
    }
}
