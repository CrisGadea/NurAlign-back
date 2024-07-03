package ar.edu.unlam.nuralign.infrastructure.repositories;

import ar.edu.unlam.nuralign.infrastructure.entities.MedicationTrackerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface JpaMedicationTrackerRepository extends JpaRepository<MedicationTrackerEntity, Long> {
    List<MedicationTrackerEntity> findAllByPatientId(Long patientId);
    MedicationTrackerEntity findByEffectiveDate(LocalDate effectiveDate);
    MedicationTrackerEntity findByPatientIdAndEffectiveDate(Long patientId, LocalDate effectiveDate);
    Boolean existsByPatientIdAndEffectiveDate(Long patientId, LocalDate effectiveDate);

    @Query ("SELECT m FROM  MedicationTrackerEntity m WHERE m.patientId = :patientId AND m.effectiveDate BETWEEN :fromDate AND :toDate ORDER BY m.effectiveDate ASC")
    List<MedicationTrackerEntity>findAllByMedicationIdAndRangeDate( @Param("patientId") Long patientId,
                                                                   @Param("fromDate") LocalDate fromDate,
                                                                   @Param("toDate") LocalDate toDate);


}
