package ar.edu.unlam.nuralign.infrastructure.repositories;

import ar.edu.unlam.nuralign.domain.models.MedicationTracker;
import ar.edu.unlam.nuralign.infrastructure.entities.MedicationTrackerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface JpaMedicationTrackerRepository extends JpaRepository<MedicationTrackerEntity, Long> {
    List<MedicationTrackerEntity> findAllByPatientId(Long patientId);
    List<MedicationTrackerEntity> findAllByEffectiveDate(LocalDate effectiveDate);
    List<MedicationTrackerEntity> findAllByPatientIdAndEffectiveDate(Long patientId, LocalDate effectiveDate);
}
