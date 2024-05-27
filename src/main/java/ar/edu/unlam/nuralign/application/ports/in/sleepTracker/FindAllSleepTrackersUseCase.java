package ar.edu.unlam.nuralign.application.ports.in.sleepTracker;

import ar.edu.unlam.nuralign.domain.models.SleepTracker;

import java.util.List;

public interface FindAllSleepTrackersUseCase {
    List<SleepTracker> findAllSleepTrackers();
}
