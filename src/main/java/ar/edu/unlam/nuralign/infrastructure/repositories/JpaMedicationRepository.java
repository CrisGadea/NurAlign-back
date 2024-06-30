package ar.edu.unlam.nuralign.infrastructure.repositories;

import ar.edu.unlam.nuralign.infrastructure.entities.MedicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface JpaMedicationRepository extends JpaRepository<MedicationEntity, Long> {
    List<MedicationEntity> findAllByPatientId(Long patientId);
    @Query("SELECT m FROM MedicationEntity m WHERE m.patientId = ?1 AND m.id = ?2")
    MedicationEntity findByPatientIdAndMedicationId(Long patientId, Long medicationID);
    @Query("SELECT m FROM MedicationEntity m join MedicationTrackerEntity mt ON m.patientId=mt.patientId WHERE m.patientId = :patientId AND mt.effectiveDate BETWEEN :fromDate AND :toDate AND mt.takenFlag = :takenFlag ORDER BY mt.effectiveDate ASC")
    List<MedicationEntity> findAllMedicationByPatientId( @Param("patientId") Long patientId,
                                                         @Param("fromDate") LocalDate fromDate,
                                                         @Param("toDate") LocalDate toDate,
                                                         @Param("takenFlag") Character takenFlag);

}
