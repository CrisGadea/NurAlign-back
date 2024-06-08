package ar.edu.unlam.nuralign.application.ports.in.moodTracker;

import ar.edu.unlam.nuralign.domain.models.MoodTracker;

import java.util.List;

public interface FindAllMoodTrackersByPatientIdAndEffectiveDateUseCase {
    List<MoodTracker> findAllMoodTrackersByPatientIdAndEffectiveDate(Long patientId, String effectiveDate);
}
