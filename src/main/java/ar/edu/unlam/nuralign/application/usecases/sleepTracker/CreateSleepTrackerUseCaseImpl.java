package ar.edu.unlam.nuralign.application.usecases.sleepTracker;

import ar.edu.unlam.nuralign.application.ports.in.sleepTracker.CreateSleepTrackerUseCase;
import ar.edu.unlam.nuralign.application.ports.out.SleepTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.SleepTracker;

public class CreateSleepTrackerUseCaseImpl implements CreateSleepTrackerUseCase {
    private final SleepTrackerRepositoryPort repository;

    public CreateSleepTrackerUseCaseImpl(SleepTrackerRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public SleepTracker createSleepTracker(SleepTracker sleepTracker) {
        return repository.save(sleepTracker);
    }
}
