package ar.edu.unlam.nuralign.application.usecases.sleepTraker;

import ar.edu.unlam.nuralign.application.ports.in.sleepTraker.FindSleepTrakerUseCase;
import ar.edu.unlam.nuralign.application.ports.out.SleepTrakerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.SleepTracker;

import java.util.Optional;

public class FindSleepTrakerUseCaseImpl implements FindSleepTrakerUseCase {
    private final SleepTrakerRepositoryPort repository;

    public FindSleepTrakerUseCaseImpl(SleepTrakerRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Optional<SleepTracker> findSleepTraker(Long patientId) {
        return repository.findById(patientId);
    }


}
