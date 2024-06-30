package ar.edu.unlam.nuralign.infrastructure.repositories;

import ar.edu.unlam.nuralign.infrastructure.entities.SleepTrackerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface JpaSleepTrackerRepository extends JpaRepository<SleepTrackerEntity, Long> {
    List<SleepTrackerEntity> findAllByPatientId(Long patientId);
    SleepTrackerEntity findByPatientIdAndEffectiveDate(Long patientId, LocalDate effectiveDate);


    @Query("SELECT s FROM SleepTrackerEntity s  WHERE s.patientId = :patientId AND s.effectiveDate BETWEEN :fromDate AND :toDate ORDER BY s.effectiveDate ASC")
    List<SleepTrackerEntity>findAllByPatientIdByRangeDate(@Param("patientId")Long patientId,
                                                          @Param("fromDate") LocalDate fromDate,
                                                          @Param("toDate") LocalDate toDate);
}
