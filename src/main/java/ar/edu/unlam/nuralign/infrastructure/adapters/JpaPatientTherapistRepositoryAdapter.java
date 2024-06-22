package ar.edu.unlam.nuralign.infrastructure.adapters;

import ar.edu.unlam.nuralign.application.ports.out.PatientTherapistRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.PatientTherapist;
import ar.edu.unlam.nuralign.infrastructure.mappers.PatientTherapistMapper;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaPatientTherapistRepository;

import java.util.List;

public class JpaPatientTherapistRepositoryAdapter implements PatientTherapistRepositoryPort {

    private JpaPatientTherapistRepository repository;

    public JpaPatientTherapistRepositoryAdapter(JpaPatientTherapistRepository repository) {
        this.repository = repository;
    }

    @Override
    public void deletePatientTherapistAssignation(Long patientId, Long therapistId) {
        repository.deleteByPatientIdAndTherapistId(patientId, therapistId);
    }

    @Override
    public PatientTherapist assignPatientToTherapist(PatientTherapist patientTherapist) {
        return PatientTherapistMapper.toModel(repository.save(PatientTherapistMapper.toEntity(patientTherapist)));
    }

    @Override
    public List<PatientTherapist> findAllPatientTherapistAssignations(Long patientId) {
        return repository.findAllByPatientId(patientId).stream()
                .map(PatientTherapistMapper::toModel)
                .toList();
    }


}
