package ar.edu.unlam.nuralign.infrastructure.repositories;

import ar.edu.unlam.nuralign.infrastructure.entities.MoodTrackerEntity;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface JpaMoodTrackerRepository extends JpaRepository<MoodTrackerEntity, Long>{
    List<MoodTrackerEntity> findAllByPatientId(Long patientId);
    @Query("SELECT m FROM MoodTrackerEntity m WHERE m.patientId = :patientId AND m.effectiveDate = :effectiveDate")
    MoodTrackerEntity findByPatientIdAndEffectiveDate(Long patientId, LocalDate effectiveDate);
}
