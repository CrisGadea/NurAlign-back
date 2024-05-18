package ar.edu.unlam.nuralign.application.ports.in.sleepTraker;

import ar.edu.unlam.nuralign.domain.models.SleepTracker;

public interface CreateSleepTrakerUseCase {
    SleepTracker createSleepTraker(SleepTracker sleepTracker);
}
