package ar.edu.unlam.nuralign.infrastructure.repositories;
import ar.edu.unlam.nuralign.infrastructure.entities.TherapySessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface JpaTherapySessionRepository extends JpaRepository<TherapySessionEntity,Long> {

    List<TherapySessionEntity> findAllByPatientId(Long patientId);

    List<TherapySessionEntity> findAllByTherapistId(Long id);

    TherapySessionEntity findByTherapistIdAndPatientIdAndEffectiveDate(
            Long therapistId, Long patientId, String effectiveDate
    );

    List<TherapySessionEntity> findAllByPatientIdAndTherapistId(
            Long patientId, Long therapistId
    );

    @Query("SELECT t from TherapySessionEntity t  WHERE t.patientId = :patientId AND t.effectiveDate BETWEEN :fromDate AND :toDate ORDER BY t.effectiveDate ASC")
    List<TherapySessionEntity> findAllByPatientIdByRangeDate(@Param ("patientId")Long patientId,
                                                                  @Param("fromDate") String fromDate,
                                                                  @Param("toDate") String toDate);

}