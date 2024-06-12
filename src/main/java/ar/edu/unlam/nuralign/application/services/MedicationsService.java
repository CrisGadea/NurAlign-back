package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.medication.*;
import ar.edu.unlam.nuralign.domain.models.Medication;

import java.util.List;
import java.util.Optional;

public class MedicationsService implements CreateMedicationUseCase, FindMedicationUseCase, FindAllMedicationsUseCase,
        FindMedicationsByPatientIdUseCase, UpdateMedicationUseCase, DeleteMedicationUseCase{

    private final CreateMedicationUseCase createMedicationUseCase;
    private final FindMedicationUseCase findMedicationUseCase;
    private final FindAllMedicationsUseCase findAllMedicationsUseCase;
    private final FindMedicationsByPatientIdUseCase findMedicationsByPatientIdUseCase;
    private final UpdateMedicationUseCase updateMedicationTrackerUseCase;
    private final DeleteMedicationUseCase deleteMedicationUseCase;

    public MedicationsService(CreateMedicationUseCase createMedicationUseCase,
                              FindMedicationUseCase findMedicationUseCase,
                              FindAllMedicationsUseCase findAllMedicationsUseCase,
                              FindMedicationsByPatientIdUseCase findMedicationsByPatientIdUseCase,
                              UpdateMedicationUseCase updateMedicationTrackerUseCase,
                              DeleteMedicationUseCase deleteMedicationUseCase) {
        this.createMedicationUseCase = createMedicationUseCase;
        this.findMedicationUseCase = findMedicationUseCase;
        this.findAllMedicationsUseCase = findAllMedicationsUseCase;
        this.findMedicationsByPatientIdUseCase = findMedicationsByPatientIdUseCase;
        this.updateMedicationTrackerUseCase = updateMedicationTrackerUseCase;
        this.deleteMedicationUseCase = deleteMedicationUseCase;
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

    @Override
    public Optional<Medication> updateMedication(Medication medication, Long patientId) {
        return updateMedicationTrackerUseCase.updateMedication(medication, patientId);
    }

    @Override
    public void deleteMedication(Long medicationId) {
        deleteMedicationUseCase.deleteMedication(medicationId);
    }

}