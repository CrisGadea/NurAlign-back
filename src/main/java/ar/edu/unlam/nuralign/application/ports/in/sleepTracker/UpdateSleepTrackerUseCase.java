package ar.edu.unlam.nuralign.application.ports.in.sleepTracker;

import ar.edu.unlam.nuralign.domain.models.SleepTracker;

import java.util.Optional;

public interface UpdateSleepTrackerUseCase {
    Optional<SleepTracker> updateSleepTracker(SleepTracker sleepTracker, Long patientId);
}
