package ar.edu.unlam.nuralign.application.usecases.moodTracker;

import ar.edu.unlam.nuralign.application.ports.in.moodTracker.CreateMoodTrackerUseCase;
import ar.edu.unlam.nuralign.application.ports.out.MoodTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.MoodTracker;
import ar.edu.unlam.nuralign.infrastructure.dtos.MoodTrackerDto;
import ar.edu.unlam.nuralign.infrastructure.mappers.MoodTrackerMapper;

public class CreateMoodTrackerUseCaseImpl implements CreateMoodTrackerUseCase {

    private final MoodTrackerRepositoryPort moodTrackerRepositoryPort;

    public CreateMoodTrackerUseCaseImpl(MoodTrackerRepositoryPort moodTrackerRepositoryPort) {
        this.moodTrackerRepositoryPort = moodTrackerRepositoryPort;
    }

    @Override
    public MoodTracker createMoodTracker(MoodTrackerDto moodTracker){
        return moodTrackerRepositoryPort.save(MoodTrackerMapper.toModel(moodTracker));
    }

}
