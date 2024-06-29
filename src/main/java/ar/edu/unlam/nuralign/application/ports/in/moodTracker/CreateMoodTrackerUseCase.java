package ar.edu.unlam.nuralign.application.ports.in.moodTracker;

import ar.edu.unlam.nuralign.domain.models.MoodTracker;
import ar.edu.unlam.nuralign.infrastructure.dtos.MoodTrackerDto;

public interface CreateMoodTrackerUseCase {
    MoodTracker createMoodTracker(MoodTracker moodTracker);
}
