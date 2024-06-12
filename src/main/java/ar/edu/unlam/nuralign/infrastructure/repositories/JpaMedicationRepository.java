package ar.edu.unlam.nuralign.infrastructure.repositories;

import ar.edu.unlam.nuralign.infrastructure.entities.MedicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaMedicationRepository extends JpaRepository<MedicationEntity, Long> {
    List<MedicationEntity> findAllByPatientId(Long patientId);
    @Query("SELECT m FROM MedicationEntity m WHERE m.patientId = ?1 AND m.id = ?2")
    MedicationEntity findByPatientIdAndMedicationId(Long patientId, Long medicationID);
}
