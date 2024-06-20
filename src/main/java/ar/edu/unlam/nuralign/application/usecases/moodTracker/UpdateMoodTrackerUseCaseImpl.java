package ar.edu.unlam.nuralign.application.usecases.moodTracker;

import ar.edu.unlam.nuralign.application.ports.in.moodTracker.UpdateMoodTrackerUseCase;
import ar.edu.unlam.nuralign.application.ports.out.MoodTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.MoodTracker;
import ar.edu.unlam.nuralign.infrastructure.entities.MoodTrackerEntity;
import ar.edu.unlam.nuralign.infrastructure.mappers.MoodTrackerMapper;

import java.time.LocalDate;

public class UpdateMoodTrackerUseCaseImpl implements UpdateMoodTrackerUseCase {

    private final MoodTrackerRepositoryPort moodTrackerRepositoryPort;

    public UpdateMoodTrackerUseCaseImpl(MoodTrackerRepositoryPort moodTrackerRepositoryPort) {
        this.moodTrackerRepositoryPort = moodTrackerRepositoryPort;
    }

    @Override
    public MoodTracker updateMoodTracker(MoodTracker moodTracker, Long patientId, LocalDate effectiveDate){
        return MoodTrackerMapper.toModel(moodTrackerRepositoryPort.update(moodTracker, patientId, effectiveDate));
    }

}
