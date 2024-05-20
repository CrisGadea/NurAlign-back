package ar.edu.unlam.nuralign.application.usecases.moodTracker;

import ar.edu.unlam.nuralign.application.ports.in.moodTracker.FindAllMoodTrackersUseCase;
import ar.edu.unlam.nuralign.application.ports.out.MoodTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.MoodTracker;

import java.util.List;

public class FindAllMoodTrackersUseCaseImpl implements FindAllMoodTrackersUseCase {

    private final MoodTrackerRepositoryPort repository;

    public FindAllMoodTrackersUseCaseImpl(MoodTrackerRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public List<MoodTracker> findAllMoodTrackers() {
        return repository.findAll();
    }
}
