package ar.edu.unlam.nuralign.application.usecases.sleepTracker;

import ar.edu.unlam.nuralign.application.ports.in.sleepTracker.FindAllSleepByPatientIdByRangeDateUseCase;
import ar.edu.unlam.nuralign.application.ports.out.SleepTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.SleepTracker;

import java.time.LocalDate;
import java.util.List;

public class FindAllSleepByPatientIdByRangeDateUseCaseImpl implements FindAllSleepByPatientIdByRangeDateUseCase{

    private final SleepTrackerRepositoryPort repository;

    public FindAllSleepByPatientIdByRangeDateUseCaseImpl(SleepTrackerRepositoryPort repository) {
        this.repository = repository;
    }


    @Override
    public List<SleepTracker> findAllSleepByPatientIdByRangeDate(Long patientId, LocalDate fromDate, LocalDate toDate) {
        return repository.findAllByPatientIdByRangeDate(patientId, fromDate, toDate);
    }
}
