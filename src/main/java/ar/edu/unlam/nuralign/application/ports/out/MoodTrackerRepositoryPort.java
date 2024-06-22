package ar.edu.unlam.nuralign.application.ports.out;

import ar.edu.unlam.nuralign.domain.models.MoodTracker;
import ar.edu.unlam.nuralign.infrastructure.entities.MoodTrackerEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MoodTrackerRepositoryPort {
    MoodTracker save(MoodTracker moodTracker);
    List<MoodTracker> findAll();
    MoodTracker findById(Long id);
    List<MoodTracker> findAllByPatientId(Long patientId);
    MoodTracker findByPatientIdAndEffectiveDate(Long patientId, String effectiveDate);
    Optional<MoodTracker> update(MoodTracker moodTracker, Long patientId, String effectiveDate);
}
