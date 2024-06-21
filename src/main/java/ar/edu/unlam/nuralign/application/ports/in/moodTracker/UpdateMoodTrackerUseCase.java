package ar.edu.unlam.nuralign.application.ports.in.moodTracker;

import ar.edu.unlam.nuralign.domain.models.MoodTracker;

import java.time.LocalDate;
import java.util.Optional;

public interface UpdateMoodTrackerUseCase {
    Optional<MoodTracker> updateMoodTracker(MoodTracker moodTracker, Long patientId, LocalDate effectiveDate);
}
