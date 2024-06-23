package ar.edu.unlam.nuralign.application.ports.in.moodTracker;

import ar.edu.unlam.nuralign.domain.models.MoodTracker;

import java.util.List;
import java.util.Optional;

public interface FindMoodTrackerByPatientIdAndEffectiveDateUseCase {
    Optional<MoodTracker> findMoodTrackerByPatientIdAndEffectiveDate(Long patientId, String effectiveDate);
}
