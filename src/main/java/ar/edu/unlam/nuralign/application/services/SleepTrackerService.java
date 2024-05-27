package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.sleepTracker.CreateSleepTrackerUseCase;
import ar.edu.unlam.nuralign.application.ports.in.sleepTracker.FindAllSleepTrackersByPatientUseCase;
import ar.edu.unlam.nuralign.application.ports.in.sleepTracker.FindAllSleepTrackersUseCase;
import ar.edu.unlam.nuralign.application.ports.in.sleepTracker.FindSleepTrackerUseCase;
import ar.edu.unlam.nuralign.domain.models.SleepTracker;

import java.util.List;
import java.util.Optional;

public class SleepTrackerService implements CreateSleepTrackerUseCase,
        FindSleepTrackerUseCase,
        FindAllSleepTrackersUseCase,
        FindAllSleepTrackersByPatientUseCase {

    private final CreateSleepTrackerUseCase createSleepTrackerUseCase;
    private final FindSleepTrackerUseCase findSleepTrackerUseCase;
    private final FindAllSleepTrackersUseCase findAllSleepTrackersUseCase;
    private final FindAllSleepTrackersByPatientUseCase findAllSleepTrackersByPatientUseCase;

    public SleepTrackerService(CreateSleepTrackerUseCase createSleepTrackerUseCase,
                               FindSleepTrackerUseCase findSleepTrackerUseCase,
                               FindAllSleepTrackersUseCase findAllSleepTrackersUseCase,
                               FindAllSleepTrackersByPatientUseCase findAllSleepTrackersByPatientUseCase) {
        this.createSleepTrackerUseCase = createSleepTrackerUseCase;
        this.findSleepTrackerUseCase = findSleepTrackerUseCase;
        this.findAllSleepTrackersUseCase = findAllSleepTrackersUseCase;
        this.findAllSleepTrackersByPatientUseCase = findAllSleepTrackersByPatientUseCase;
    }

    @Override
    public SleepTracker createSleepTracker(ar.edu.unlam.nuralign.domain.models.SleepTracker sleepTracker) {
        return createSleepTrackerUseCase.createSleepTracker(sleepTracker);
    }

    @Override
    public Optional<SleepTracker> findSleepTracker(Long id) {
        return findSleepTrackerUseCase.findSleepTracker(id);
    }

    @Override
    public List<SleepTracker> findAllSleepTrackers() {
        return findAllSleepTrackersUseCase.findAllSleepTrackers();
    }

    @Override
    public List<SleepTracker> findAllSleepTrackersByPatientId(Long patientId) {
        return findAllSleepTrackersByPatientUseCase.findAllSleepTrackersByPatientId(patientId);
    }

}
