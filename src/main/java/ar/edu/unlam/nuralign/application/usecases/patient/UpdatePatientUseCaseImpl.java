package ar.edu.unlam.nuralign.application.usecases.patient;

import ar.edu.unlam.nuralign.application.ports.in.patient.UpdatePatientUseCase;
import ar.edu.unlam.nuralign.application.ports.out.PatientRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.Patient;

import java.util.Optional;

public class UpdatePatientUseCaseImpl implements UpdatePatientUseCase {

    private final PatientRepositoryPort repository;

    public UpdatePatientUseCaseImpl(PatientRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Patient> updatePatient(Patient patient, Long patientId) {
        return repository.update(patient, patientId);
    }
}
