package ar.edu.unlam.nuralign.application.usecases.sleepTraker;

import ar.edu.unlam.nuralign.application.ports.in.sleepTraker.FindAllSleepTrackersByPatientUseCase;
import ar.edu.unlam.nuralign.application.ports.out.SleepTrakerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.SleepTracker;

import java.util.List;

public class FindAllSleepTrackersByPatientIdImpl implements FindAllSleepTrackersByPatientUseCase {

    private final SleepTrakerRepositoryPort sleepTrakerRepositoryPort;

    public FindAllSleepTrackersByPatientIdImpl(SleepTrakerRepositoryPort sleepTrakerRepositoryPort) {
        this.sleepTrakerRepositoryPort = sleepTrakerRepositoryPort;
    }

    @Override
    public List<SleepTracker> findAllSleepTrackersByPatientId(Long patientId) {
        return sleepTrakerRepositoryPort.findAllByPatientId(patientId);
    }

}
