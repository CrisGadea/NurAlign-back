package ar.edu.unlam.nuralign.application.usecases.patient;

import ar.edu.unlam.nuralign.application.ports.in.patient.FindAllPatientsUseCase;
import ar.edu.unlam.nuralign.application.ports.out.PatientRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.Patient;

import java.util.List;

public class FindAllPatientsUseCaseImpl implements FindAllPatientsUseCase {

    private final PatientRepositoryPort repository;

    public FindAllPatientsUseCaseImpl(PatientRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public List<Patient> findAllPatients() {
        return repository.findAll();
    }

}
