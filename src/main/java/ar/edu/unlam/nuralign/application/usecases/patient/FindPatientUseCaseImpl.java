package ar.edu.unlam.nuralign.application.usecases.patient;

import ar.edu.unlam.nuralign.application.ports.in.patient.FindPatientUseCase;
import ar.edu.unlam.nuralign.application.ports.in.therapist.FindTherapistUseCase;
import ar.edu.unlam.nuralign.application.ports.out.PatientRepositoryPort;
import ar.edu.unlam.nuralign.application.ports.out.TherapistRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.Patient;
import ar.edu.unlam.nuralign.domain.models.Therapist;

import java.util.Optional;

public class FindPatientUseCaseImpl implements FindPatientUseCase {

    private final PatientRepositoryPort repository;

    public FindPatientUseCaseImpl(PatientRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Patient> findPatient(Long id) {
        return repository.findById(id);
    }
}
