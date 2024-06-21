package ar.edu.unlam.nuralign.application.usecases.sleepTracker;

import ar.edu.unlam.nuralign.application.ports.in.sleepTracker.UpdateSleepTrackerUseCase;
import ar.edu.unlam.nuralign.application.ports.out.SleepTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.SleepTracker;

import java.util.Optional;

public class UpdateSleepTrackerUseCaseImpl implements UpdateSleepTrackerUseCase {

    private final SleepTrackerRepositoryPort sleepTrackerRepositoryPort;

    public UpdateSleepTrackerUseCaseImpl(SleepTrackerRepositoryPort sleepTrackerRepositoryPort) {
        this.sleepTrackerRepositoryPort = sleepTrackerRepositoryPort;
    }

    @Override
    public Optional<SleepTracker> updateSleepTracker(SleepTracker sleepTracker, Long patientId, String effectiveDate){
        return sleepTrackerRepositoryPort.update(sleepTracker, patientId, effectiveDate);
    }
}
