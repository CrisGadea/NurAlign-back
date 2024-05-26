package ar.edu.unlam.nuralign.application.usecases.sleepTracker;

import ar.edu.unlam.nuralign.application.ports.in.sleepTracker.FindSleepTrackerUseCase;
import ar.edu.unlam.nuralign.application.ports.out.SleepTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.SleepTracker;

import java.util.Optional;

public class FindSleepTrackerUseCaseImpl implements FindSleepTrackerUseCase {
    private final SleepTrackerRepositoryPort repository;

    public FindSleepTrackerUseCaseImpl(SleepTrackerRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Optional<SleepTracker> findSleepTracker(Long patientId) {
        return repository.findById(patientId);
    }


}
