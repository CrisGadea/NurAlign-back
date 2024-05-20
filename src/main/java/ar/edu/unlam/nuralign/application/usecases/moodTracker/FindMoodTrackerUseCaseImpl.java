package ar.edu.unlam.nuralign.application.usecases.moodTracker;

import ar.edu.unlam.nuralign.application.ports.in.moodTracker.FindMoodTrackerUseCase;
import ar.edu.unlam.nuralign.application.ports.out.MoodTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.MoodTracker;

public class FindMoodTrackerUseCaseImpl implements FindMoodTrackerUseCase {
    private final MoodTrackerRepositoryPort repository;

    public FindMoodTrackerUseCaseImpl(MoodTrackerRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public MoodTracker findMoodTracker(Long id) {
        return repository.findById(id);
    }
}
