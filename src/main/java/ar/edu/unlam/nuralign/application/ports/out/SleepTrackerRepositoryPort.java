package ar.edu.unlam.nuralign.application.ports.out;

import ar.edu.unlam.nuralign.domain.models.SleepTracker;

import java.util.List;
import java.util.Optional;

public interface SleepTrackerRepositoryPort {
    SleepTracker save(SleepTracker sleepTracker);
    Optional<SleepTracker> findById(Long id);
    List<SleepTracker> findAll();
    List<SleepTracker> findAllByPatientId(Long patientId);
}
