package ar.edu.unlam.nuralign.application.usecases.sleepTracker;

import ar.edu.unlam.nuralign.application.ports.in.sleepTracker.FindAllSleepTrackersUseCase;
import ar.edu.unlam.nuralign.application.ports.out.SleepTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.SleepTracker;

import java.util.List;

public class FindAllSleepTrackersUseCaseImpl implements FindAllSleepTrackersUseCase {
    private final SleepTrackerRepositoryPort repository;

    public FindAllSleepTrackersUseCaseImpl(SleepTrackerRepositoryPort repository) {
        this.repository = repository;
    }

    public List<SleepTracker> findAllSleepTrackers() {
        return repository.findAll();
    }

}
