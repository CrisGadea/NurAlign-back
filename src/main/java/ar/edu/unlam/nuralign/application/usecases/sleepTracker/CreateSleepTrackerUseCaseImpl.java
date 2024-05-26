package ar.edu.unlam.nuralign.application.usecases.sleepTracker;

import ar.edu.unlam.nuralign.application.ports.in.sleepTracker.CreateSleepTrackerUseCase;
import ar.edu.unlam.nuralign.application.ports.out.SleepTrakerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.SleepTracker;

public class CreateSleepTrackerUseCaseImpl implements CreateSleepTrackerUseCase {
    private final SleepTrakerRepositoryPort repository;

    public CreateSleepTrackerUseCaseImpl(SleepTrakerRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public SleepTracker createSleepTraker(SleepTracker sleepTracker) {
        return repository.save(sleepTracker);
    }
}
