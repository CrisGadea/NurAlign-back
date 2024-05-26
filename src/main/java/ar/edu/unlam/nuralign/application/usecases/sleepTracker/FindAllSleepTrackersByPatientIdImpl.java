package ar.edu.unlam.nuralign.application.usecases.sleepTracker;

import ar.edu.unlam.nuralign.application.ports.in.sleepTracker.FindAllSleepTrackersByPatientUseCase;
import ar.edu.unlam.nuralign.application.ports.out.SleepTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.SleepTracker;

import java.util.List;

public class FindAllSleepTrackersByPatientIdImpl implements FindAllSleepTrackersByPatientUseCase {

    private final SleepTrackerRepositoryPort sleepTrackerRepositoryPort;

    public FindAllSleepTrackersByPatientIdImpl(SleepTrackerRepositoryPort sleepTrackerRepositoryPort) {
        this.sleepTrackerRepositoryPort = sleepTrackerRepositoryPort;
    }

    @Override
    public List<SleepTracker> findAllSleepTrackersByPatientId(Long patientId) {
        return sleepTrackerRepositoryPort.findAllByPatientId(patientId);
    }

}
