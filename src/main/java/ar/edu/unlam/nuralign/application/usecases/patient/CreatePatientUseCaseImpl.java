package ar.edu.unlam.nuralign.application.usecases.patient;

import ar.edu.unlam.nuralign.application.ports.in.patient.CreatePatientUseCase;
import ar.edu.unlam.nuralign.application.ports.out.PatientRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.Patient;

public class CreatePatientUseCaseImpl implements CreatePatientUseCase {

    private final PatientRepositoryPort repository;

    public CreatePatientUseCaseImpl(PatientRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Patient createPatient(Patient patient) {
        return repository.save(patient);
    }

}
