package ar.edu.unlam.nuralign.application.ports.in.patient;

import ar.edu.unlam.nuralign.domain.models.Patient;

import java.util.Optional;

public interface FindPatientUseCase {
    Optional<Patient> findPatient(Long id);
}
