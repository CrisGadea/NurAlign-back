package ar.edu.unlam.nuralign.application.ports.in.sleepTraker;

import ar.edu.unlam.nuralign.domain.models.SleepTracker;

import java.util.List;

public interface FindAllSleepTrackersByPatientUseCase {
    List<SleepTracker> findAllSleepTrackersByPatientId(Long patientId);
}
