package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.sleepTracker.*;
import ar.edu.unlam.nuralign.domain.models.SleepTracker;

import java.util.List;
import java.util.Optional;

public class SleepTrackerService implements CreateSleepTrackerUseCase,
        FindSleepTrackerUseCase,
        FindAllSleepTrackersUseCase,
        FindAllSleepTrackersByPatientUseCase,
        FindAllSleepTrackersByPatientIdAndEffectiveDateUseCase {

    private final CreateSleepTrackerUseCase createSleepTrackerUseCase;
    private final FindSleepTrackerUseCase findSleepTrackerUseCase;
    private final FindAllSleepTrackersUseCase findAllSleepTrackersUseCase;
    private final FindAllSleepTrackersByPatientUseCase findAllSleepTrackersByPatientUseCase;
    private final FindAllSleepTrackersByPatientIdAndEffectiveDateUseCase findAllSleepTrackersByPatientIdAndEffectiveDateUseCase;

    public SleepTrackerService(CreateSleepTrackerUseCase createSleepTrackerUseCase,
                               FindSleepTrackerUseCase findSleepTrackerUseCase,
                               FindAllSleepTrackersUseCase findAllSleepTrackersUseCase,
                               FindAllSleepTrackersByPatientUseCase findAllSleepTrackersByPatientUseCase,
                               FindAllSleepTrackersByPatientIdAndEffectiveDateUseCase findAllSleepTrackersByPatientIdAndEffectiveDateUseCase) {
        this.createSleepTrackerUseCase = createSleepTrackerUseCase;
        this.findSleepTrackerUseCase = findSleepTrackerUseCase;
        this.findAllSleepTrackersUseCase = findAllSleepTrackersUseCase;
        this.findAllSleepTrackersByPatientUseCase = findAllSleepTrackersByPatientUseCase;
        this.findAllSleepTrackersByPatientIdAndEffectiveDateUseCase = findAllSleepTrackersByPatientIdAndEffectiveDateUseCase;

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

    @Override
    public List<SleepTracker> findAllSleepTrackersByPatientIdAndEffectiveDate(Long patientId, String effectiveDate) {
        return findAllSleepTrackersByPatientIdAndEffectiveDateUseCase.findAllSleepTrackersByPatientIdAndEffectiveDate(patientId, effectiveDate);
    }

}
