package ar.edu.unlam.nuralign.infrastructure.adapters;

import ar.edu.unlam.nuralign.application.ports.out.PatientRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.Patient;
import ar.edu.unlam.nuralign.infrastructure.entities.PatientEntity;
import ar.edu.unlam.nuralign.infrastructure.mappers.PatientMapper;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaPatientRepository;
import ar.edu.unlam.nuralign.infrastructure.utils.CheckPassword;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JpaPatientRepositoryAdapter implements PatientRepositoryPort {

    private final JpaPatientRepository repository;

    public JpaPatientRepositoryAdapter(JpaPatientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Patient save(Patient patient) {
        PatientEntity patientEntity = PatientMapper.mapToEntity(patient);
        patientEntity.setRegisteredFlag("Y");
        patientEntity.setCreatedAt(LocalDateTime.now());
        patientEntity.setUpdatedAt(LocalDateTime.now());
        patientEntity.setCompanionNotifications("Y");
        patientEntity.setGeneralNotifications("Y");
        CheckPassword checkPassword = new CheckPassword(patient.getPassword());
        patientEntity.setPassword(checkPassword.hashPassword());
        return PatientMapper.mapToDomain(repository.save(patientEntity));
    }

    @Override
    public Optional<Patient> update(Patient patient, Long id) {
        if (repository.existsById(id)) {
            PatientEntity patientEntity = PatientMapper.mapToEntity(patient);
            patientEntity.setId(id);
            patientEntity.setUpdatedAt(LocalDateTime.now());
            return Optional.of(PatientMapper.mapToDomain(repository.save(patientEntity)));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Patient> findById(Long id) {
        return repository.findById(id)
                .map(PatientMapper::mapToDomain);
    }

    @Override
    public List<Patient> findAll() {
        return repository.findAll().stream()
                .map(PatientMapper::mapToDomain)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
