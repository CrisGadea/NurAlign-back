package ar.edu.unlam.nuralign.application.ports.in.sleepTraker;

import ar.edu.unlam.nuralign.domain.models.SleepTracker;

import java.util.Optional;

public interface FindSleepTrakerUseCase {
    Optional<SleepTracker> findSleepTraker(Long id);
}
