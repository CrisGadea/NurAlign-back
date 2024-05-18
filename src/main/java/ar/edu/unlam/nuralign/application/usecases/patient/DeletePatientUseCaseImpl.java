package ar.edu.unlam.nuralign.application.usecases.patient;

import ar.edu.unlam.nuralign.application.ports.in.patient.DeletePatientUseCase;
import ar.edu.unlam.nuralign.application.ports.out.PatientRepositoryPort;

public class DeletePatientUseCaseImpl implements DeletePatientUseCase {

    private final PatientRepositoryPort repository;

    public DeletePatientUseCaseImpl(PatientRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public boolean deletePatient(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isEmpty();
    }
}
