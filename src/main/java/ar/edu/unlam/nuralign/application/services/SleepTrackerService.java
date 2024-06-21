package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.sleepTracker.*;
import ar.edu.unlam.nuralign.domain.models.SleepTracker;

import java.util.List;
import java.util.Optional;

public class SleepTrackerService implements CreateSleepTrackerUseCase,
        FindSleepTrackerUseCase,
        FindAllSleepTrackersUseCase,
        FindAllSleepTrackersByPatientUseCase,
        FindSleepTrackerByPatientIdAndEffectiveDateUseCase,
        UpdateSleepTrackerUseCase {

    private final CreateSleepTrackerUseCase createSleepTrackerUseCase;
    private final FindSleepTrackerUseCase findSleepTrackerUseCase;
    private final FindAllSleepTrackersUseCase findAllSleepTrackersUseCase;
    private final FindAllSleepTrackersByPatientUseCase findAllSleepTrackersByPatientUseCase;
    private final FindSleepTrackerByPatientIdAndEffectiveDateUseCase findSleepTrackerByPatientIdAndEffectiveDateUseCase;
    private final UpdateSleepTrackerUseCase updateSleepTrackerUseCase;

    public SleepTrackerService(CreateSleepTrackerUseCase createSleepTrackerUseCase,
                               FindSleepTrackerUseCase findSleepTrackerUseCase,
                               FindAllSleepTrackersUseCase findAllSleepTrackersUseCase,
                               FindAllSleepTrackersByPatientUseCase findAllSleepTrackersByPatientUseCase,
                               FindSleepTrackerByPatientIdAndEffectiveDateUseCase findSleepTrackerByPatientIdAndEffectiveDateUseCase,
                               UpdateSleepTrackerUseCase updateSleepTrackerUseCase) {
        this.createSleepTrackerUseCase = createSleepTrackerUseCase;
        this.findSleepTrackerUseCase = findSleepTrackerUseCase;
        this.findAllSleepTrackersUseCase = findAllSleepTrackersUseCase;
        this.findAllSleepTrackersByPatientUseCase = findAllSleepTrackersByPatientUseCase;
        this.findSleepTrackerByPatientIdAndEffectiveDateUseCase = findSleepTrackerByPatientIdAndEffectiveDateUseCase;
        this.updateSleepTrackerUseCase = updateSleepTrackerUseCase;

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
    public SleepTracker findSleepTrackerByPatientIdAndEffectiveDate(Long patientId, String effectiveDate) {
        return findSleepTrackerByPatientIdAndEffectiveDateUseCase.findSleepTrackerByPatientIdAndEffectiveDate(patientId, effectiveDate);
    }

    @Override
    public Optional<SleepTracker> updateSleepTracker(SleepTracker sleepTracker, Long patientId, String effectiveDate) {
        return updateSleepTrackerUseCase.updateSleepTracker(sleepTracker, patientId, effectiveDate);
    }

}
