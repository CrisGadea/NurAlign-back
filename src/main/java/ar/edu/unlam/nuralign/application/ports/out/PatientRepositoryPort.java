package ar.edu.unlam.nuralign.application.ports.out;

import ar.edu.unlam.nuralign.domain.models.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientRepositoryPort {
    Patient save(Patient patient);
    Optional<Patient> update(Patient patient, Long id);
    Optional<Patient> findById(Long id);
    List<Patient> findAll();
    void deleteById(Long id);
    List<Patient> findAllByTherapistId(Long id);
}
