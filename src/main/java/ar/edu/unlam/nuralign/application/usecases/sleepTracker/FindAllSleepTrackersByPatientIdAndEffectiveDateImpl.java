package ar.edu.unlam.nuralign.application.usecases.sleepTracker;

import ar.edu.unlam.nuralign.application.ports.in.sleepTracker.FindAllSleepTrackersByPatientIdAndEffectiveDateUseCase;
import ar.edu.unlam.nuralign.application.ports.out.SleepTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.SleepTracker;

import java.time.LocalDate;
import java.util.List;

public class FindAllSleepTrackersByPatientIdAndEffectiveDateImpl implements FindAllSleepTrackersByPatientIdAndEffectiveDateUseCase {
    private final SleepTrackerRepositoryPort sleepTrackerRepository;

    public FindAllSleepTrackersByPatientIdAndEffectiveDateImpl(SleepTrackerRepositoryPort sleepTrackerRepository) {
        this.sleepTrackerRepository = sleepTrackerRepository;
    }

    @Override
    public List<SleepTracker> findAllSleepTrackersByPatientIdAndEffectiveDate(Long patientId, String effectiveDate) {
        return sleepTrackerRepository.findAllSleepTrackersByPatientIdAndEffectiveDate(patientId, effectiveDate);
    }
}
