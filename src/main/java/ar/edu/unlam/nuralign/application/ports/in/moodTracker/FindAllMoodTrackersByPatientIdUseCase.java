package ar.edu.unlam.nuralign.application.ports.in.moodTracker;

import ar.edu.unlam.nuralign.domain.models.MoodTracker;

import java.util.List;

public interface FindAllMoodTrackersByPatientIdUseCase {
    List<MoodTracker> findAllMoodTrackersByPatientId(Long patientId);
}
