package ar.edu.unlam.nuralign.application.ports.in.moodTracker;

import ar.edu.unlam.nuralign.domain.models.MoodTracker;

import java.time.LocalDate;

public interface UpdateMoodTrackerUseCase {
    MoodTracker updateMoodTracker(MoodTracker moodTracker, Long patientId, LocalDate effectiveDate);
}
