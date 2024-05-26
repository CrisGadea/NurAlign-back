package ar.edu.unlam.nuralign.application.ports.in.sleepTracker;

import ar.edu.unlam.nuralign.domain.models.SleepTracker;

public interface CreateSleepTrackerUseCase {
    SleepTracker createSleepTraker(SleepTracker sleepTracker);
}
