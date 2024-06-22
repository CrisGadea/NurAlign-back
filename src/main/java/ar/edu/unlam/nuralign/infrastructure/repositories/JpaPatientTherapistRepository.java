package ar.edu.unlam.nuralign.infrastructure.repositories;

import ar.edu.unlam.nuralign.infrastructure.entities.PatientTherapistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaPatientTherapistRepository extends JpaRepository<PatientTherapistEntity, Long> {
    List<PatientTherapistEntity> findAllByPatientId(Long patientId);
    void deleteByPatientIdAndTherapistId(Long patientId, Long therapistId);
}
