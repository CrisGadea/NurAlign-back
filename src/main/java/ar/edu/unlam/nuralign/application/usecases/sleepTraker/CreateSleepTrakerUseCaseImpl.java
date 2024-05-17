package ar.edu.unlam.nuralign.application.usecases.sleepTraker;

import ar.edu.unlam.nuralign.application.ports.in.sleepTraker.CreateSleepTrakerUseCase;
import ar.edu.unlam.nuralign.application.ports.out.SleepTrakerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.SleepTracker;

public class CreateSleepTrakerUseCaseImpl implements CreateSleepTrakerUseCase {
    private final SleepTrakerRepositoryPort repository;

    public CreateSleepTrakerUseCaseImpl(SleepTrakerRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public SleepTracker createSleepTraker(SleepTracker sleepTracker) {
        return repository.save(sleepTracker);
    }
}
