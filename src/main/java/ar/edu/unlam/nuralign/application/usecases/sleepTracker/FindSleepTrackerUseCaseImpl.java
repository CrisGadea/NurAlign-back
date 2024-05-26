package ar.edu.unlam.nuralign.application.usecases.sleepTracker;

import ar.edu.unlam.nuralign.application.ports.in.sleepTracker.FindSleepTrackerUseCase;
import ar.edu.unlam.nuralign.application.ports.out.SleepTrakerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.SleepTracker;

import java.util.Optional;

public class FindSleepTrackerUseCaseImpl implements FindSleepTrackerUseCase {
    private final SleepTrakerRepositoryPort repository;

    public FindSleepTrackerUseCaseImpl(SleepTrakerRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Optional<SleepTracker> findSleepTraker(Long patientId) {
        return repository.findById(patientId);
    }


}
