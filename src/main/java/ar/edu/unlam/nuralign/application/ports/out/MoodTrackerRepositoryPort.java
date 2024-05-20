package ar.edu.unlam.nuralign.application.ports.out;

import ar.edu.unlam.nuralign.domain.models.MoodTracker;

import java.util.List;

public interface MoodTrackerRepositoryPort {
    MoodTracker save(MoodTracker moodTracker);
    List<MoodTracker> findAll();
    MoodTracker findById(Long id);
}
