package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.sleepTraker.CreateSleepTrakerUseCase;
import ar.edu.unlam.nuralign.application.ports.in.sleepTraker.FindAllSleepTrackersByPatientUseCase;
import ar.edu.unlam.nuralign.application.ports.in.sleepTraker.FindAllSleepTrakersUseCase;
import ar.edu.unlam.nuralign.application.ports.in.sleepTraker.FindSleepTrakerUseCase;
import ar.edu.unlam.nuralign.domain.models.SleepTracker;

import java.util.List;
import java.util.Optional;

public class SleepTrakerService implements CreateSleepTrakerUseCase,
        FindSleepTrakerUseCase,
        FindAllSleepTrakersUseCase,
        FindAllSleepTrackersByPatientUseCase {

    private final CreateSleepTrakerUseCase createSleepTrakerUseCase;
    private final FindSleepTrakerUseCase findSleepTrakerUseCase;
    private final FindAllSleepTrakersUseCase findAllSleepTrakersUseCase;
    private final FindAllSleepTrackersByPatientUseCase findAllSleepTrackersByPatientUseCase;

    public SleepTrakerService(CreateSleepTrakerUseCase createSleepTrakerUseCase,
                              FindSleepTrakerUseCase findSleepTrakerUseCase,
                              FindAllSleepTrakersUseCase findAllSleepTrakersUseCase,
                              FindAllSleepTrackersByPatientUseCase findAllSleepTrackersByPatientUseCase) {
        this.createSleepTrakerUseCase = createSleepTrakerUseCase;
        this.findSleepTrakerUseCase = findSleepTrakerUseCase;
        this.findAllSleepTrakersUseCase = findAllSleepTrakersUseCase;
        this.findAllSleepTrackersByPatientUseCase = findAllSleepTrackersByPatientUseCase;
    }

    @Override
    public SleepTracker createSleepTraker(ar.edu.unlam.nuralign.domain.models.SleepTracker sleepTracker) {
        return createSleepTrakerUseCase.createSleepTraker(sleepTracker);
    }

    @Override
    public Optional<SleepTracker> findSleepTraker(Long id) {
        return findSleepTrakerUseCase.findSleepTraker(id);
    }

    @Override
    public List<SleepTracker> findAllSleepTrakers() {
        return findAllSleepTrakersUseCase.findAllSleepTrakers();
    }

    @Override
    public List<SleepTracker> findAllSleepTrackersByPatientId(Long patientId) {
        return findAllSleepTrackersByPatientUseCase.findAllSleepTrackersByPatientId(patientId);
    }

}
