package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.sleepTracker.CreateSleepTrackerUseCase;
import ar.edu.unlam.nuralign.application.ports.in.sleepTracker.FindAllSleepTrackersUseCase;
import ar.edu.unlam.nuralign.application.ports.in.sleepTracker.FindSleepTrackerUseCase;
import ar.edu.unlam.nuralign.domain.models.SleepTracker;

import java.util.List;
import java.util.Optional;

public class SleepTrackerService implements CreateSleepTrackerUseCase, FindSleepTrackerUseCase, FindAllSleepTrackersUseCase {

    private final CreateSleepTrackerUseCase createSleepTrackerUseCase;
    private final FindSleepTrackerUseCase findSleepTrackerUseCase;
    private final FindAllSleepTrackersUseCase findAllSleepTrackersUseCase;

    public SleepTrackerService(CreateSleepTrackerUseCase createSleepTrackerUseCase, FindSleepTrackerUseCase findSleepTrackerUseCase, FindAllSleepTrackersUseCase findAllSleepTrackersUseCase) {
        this.createSleepTrackerUseCase = createSleepTrackerUseCase;
        this.findSleepTrackerUseCase = findSleepTrackerUseCase;
        this.findAllSleepTrackersUseCase = findAllSleepTrackersUseCase;
    }

    @Override
    public SleepTracker createSleepTraker(ar.edu.unlam.nuralign.domain.models.SleepTracker sleepTracker) {
        return createSleepTrackerUseCase.createSleepTraker(sleepTracker);
    }

    @Override
    public Optional<SleepTracker> findSleepTraker(Long id) {
        return findSleepTrackerUseCase.findSleepTraker(id);
    }

    @Override
    public List<SleepTracker> findAllSleepTrakers() {
        return findAllSleepTrackersUseCase.findAllSleepTrakers();
    }
}
