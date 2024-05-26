package ar.edu.unlam.nuralign.application.usecases.sleepTracker;

import ar.edu.unlam.nuralign.application.ports.in.sleepTracker.FindAllSleepTrackersUseCase;
import ar.edu.unlam.nuralign.application.ports.out.SleepTrakerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.SleepTracker;

import java.util.List;

public class FindAllSleepTrackersUseCaseImpl implements FindAllSleepTrackersUseCase {
    private final SleepTrakerRepositoryPort repository;

    public FindAllSleepTrackersUseCaseImpl(SleepTrakerRepositoryPort repository) {
        this.repository = repository;
    }

    public List<SleepTracker> findAllSleepTrakers() {
        return repository.findAll();
    }

}
