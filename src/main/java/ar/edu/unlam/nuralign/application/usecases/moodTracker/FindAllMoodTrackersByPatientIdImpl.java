package ar.edu.unlam.nuralign.application.usecases.moodTracker;

import ar.edu.unlam.nuralign.application.ports.in.moodTracker.FindAllMoodTrackersByPatientIdUseCase;
import ar.edu.unlam.nuralign.application.ports.out.MoodTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.MoodTracker;

import java.util.List;

public class FindAllMoodTrackersByPatientIdImpl implements FindAllMoodTrackersByPatientIdUseCase {
    private final MoodTrackerRepositoryPort moodTrackerRepositoryPort;

    public FindAllMoodTrackersByPatientIdImpl(MoodTrackerRepositoryPort moodTrackerRepositoryPort) {
        this.moodTrackerRepositoryPort= moodTrackerRepositoryPort;
    }

    @Override
    public List<MoodTracker> findAllMoodTrackersByPatientId(Long patientId) {
        return moodTrackerRepositoryPort.findAllByPatientId(patientId);
    }
}
