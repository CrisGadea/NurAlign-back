package ar.edu.unlam.nuralign.application.ports.in.moodTracker;

import ar.edu.unlam.nuralign.domain.models.MoodTracker;

public interface FindMoodTrackerUseCase {
    MoodTracker findMoodTracker(Long id);
}
