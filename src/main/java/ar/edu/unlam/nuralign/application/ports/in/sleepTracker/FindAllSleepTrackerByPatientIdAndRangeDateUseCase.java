package ar.edu.unlam.nuralign.application.ports.in.sleepTracker;

import ar.edu.unlam.nuralign.domain.models.SleepTracker;

import java.time.LocalDate;
import java.util.List;

public interface FindAllSleepTrackerByPatientIdAndRangeDateUseCase {

    List<SleepTracker> findAllSleepByPatientIdByRangeDate(Long patientId, LocalDate fromDate, LocalDate toDate);
}
