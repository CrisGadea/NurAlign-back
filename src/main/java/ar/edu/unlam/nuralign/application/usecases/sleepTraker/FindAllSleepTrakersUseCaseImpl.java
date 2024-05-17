package ar.edu.unlam.nuralign.application.usecases.sleepTraker;

import ar.edu.unlam.nuralign.application.ports.in.sleepTraker.FindAllSleepTrakersUseCase;
import ar.edu.unlam.nuralign.application.ports.out.SleepTrakerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.SleepTracker;

import java.util.List;

public class FindAllSleepTrakersUseCaseImpl implements FindAllSleepTrakersUseCase {
    private final SleepTrakerRepositoryPort repository;

    public FindAllSleepTrakersUseCaseImpl(SleepTrakerRepositoryPort repository) {
        this.repository = repository;
    }

    public List<SleepTracker> findAllSleepTrakers() {
        return repository.findAll();
    }

}
