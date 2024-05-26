package ar.edu.unlam.nuralign.infrastructure.repositories;

import ar.edu.unlam.nuralign.infrastructure.entities.MedicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaMedicationRepository extends JpaRepository<MedicationEntity, Long> {
    List<MedicationEntity> findAllByPatientId(Long patientId);
}
