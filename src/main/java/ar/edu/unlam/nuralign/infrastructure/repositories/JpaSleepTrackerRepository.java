package ar.edu.unlam.nuralign.infrastructure.repositories;

import ar.edu.unlam.nuralign.infrastructure.entities.SleepTrackerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface JpaSleepTrackerRepository extends JpaRepository<SleepTrackerEntity, Long> {
    List<SleepTrackerEntity> findAllByPatientId(Long patientId);
    List<SleepTrackerEntity> findAllByPatientIdAndEffectiveDate(Long patientId, LocalDate effectiveDate);
}
