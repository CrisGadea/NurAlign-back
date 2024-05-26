package ar.edu.unlam.nuralign.application.usecases.medication;

import ar.edu.unlam.nuralign.application.ports.in.medication.FindMedicationsByPatientIdUseCase;
import ar.edu.unlam.nuralign.application.ports.out.MedicationRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.Medication;

import java.util.List;

public class FindMedicationsByPatientIdUseCaseImpl implements FindMedicationsByPatientIdUseCase {

    private final MedicationRepositoryPort jpaMedicationRepository;

    public FindMedicationsByPatientIdUseCaseImpl(MedicationRepositoryPort jpaMedicationRepository) {
        this.jpaMedicationRepository = jpaMedicationRepository;
    }

    @Override
    public List<Medication> findMedicationsByPatientId(Long patientId) {
        return jpaMedicationRepository.findAllByPatientId(patientId);
    }
}
