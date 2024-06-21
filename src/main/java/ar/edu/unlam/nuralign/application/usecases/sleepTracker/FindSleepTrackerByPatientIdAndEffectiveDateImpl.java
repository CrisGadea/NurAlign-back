package ar.edu.unlam.nuralign.application.usecases.sleepTracker;

import ar.edu.unlam.nuralign.application.ports.in.sleepTracker.FindSleepTrackerByPatientIdAndEffectiveDateUseCase;
import ar.edu.unlam.nuralign.application.ports.out.SleepTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.SleepTracker;

import java.util.List;

public class FindSleepTrackerByPatientIdAndEffectiveDateImpl implements FindSleepTrackerByPatientIdAndEffectiveDateUseCase {
    private final SleepTrackerRepositoryPort sleepTrackerRepository;

    public FindSleepTrackerByPatientIdAndEffectiveDateImpl(SleepTrackerRepositoryPort sleepTrackerRepository) {
        this.sleepTrackerRepository = sleepTrackerRepository;
    }

    @Override
    public SleepTracker findSleepTrackerByPatientIdAndEffectiveDate(Long patientId, String effectiveDate) {
        return sleepTrackerRepository.findSleepTrackerByPatientIdAndEffectiveDate(patientId, effectiveDate);
    }
}
