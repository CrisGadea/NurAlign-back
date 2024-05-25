package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.medication.CreateMedicationUseCase;
import ar.edu.unlam.nuralign.application.ports.in.medication.FindAllMedicationsUseCase;
import ar.edu.unlam.nuralign.application.ports.in.medication.FindMedicationsByPatientIdUseCase;
import ar.edu.unlam.nuralign.application.ports.in.medication.FindMedicationUseCase;
import ar.edu.unlam.nuralign.domain.models.Medication;
import ar.edu.unlam.nuralign.infrastructure.dtos.MedicationDto;

import java.util.List;

public class MedicationsService implements CreateMedicationUseCase, FindMedicationUseCase, FindAllMedicationsUseCase,
        FindMedicationsByPatientIdUseCase {

    private final CreateMedicationUseCase createMedicationUseCase;
    private final FindMedicationUseCase findMedicationUseCase;
    private final FindAllMedicationsUseCase findAllMedicationsUseCase;
    private final FindMedicationsByPatientIdUseCase findMedicationsByPatientIdUseCase;

    public MedicationsService(CreateMedicationUseCase createMedicationUseCase,
                              FindMedicationUseCase findMedicationUseCase,
                              FindAllMedicationsUseCase findAllMedicationsUseCase,
                              FindMedicationsByPatientIdUseCase findMedicationsByPatientIdUseCase) {
        this.createMedicationUseCase = createMedicationUseCase;
        this.findMedicationUseCase = findMedicationUseCase;
        this.findAllMedicationsUseCase = findAllMedicationsUseCase;
        this.findMedicationsByPatientIdUseCase = findMedicationsByPatientIdUseCase;
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
    public List<Medication> findMedicationsByPatientId(Long patientId) {
        return findMedicationsByPatientIdUseCase.findMedicationsByPatientId(patientId);
    }

    @Override
    public List<Medication> findAllMedications() {
        return findAllMedicationsUseCase.findAllMedications();
    }
}
