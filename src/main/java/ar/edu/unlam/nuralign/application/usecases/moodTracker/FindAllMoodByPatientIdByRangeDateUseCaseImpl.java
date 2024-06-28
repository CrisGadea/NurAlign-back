package ar.edu.unlam.nuralign.application.usecases.moodTracker;

import ar.edu.unlam.nuralign.application.ports.in.moodTracker.FindAllMoodByPatientIdByRangeDateUseCase;
import ar.edu.unlam.nuralign.application.ports.out.MoodTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.MoodTracker;

import java.time.LocalDate;
import java.util.List;

public class FindAllMoodByPatientIdByRangeDateUseCaseImpl implements FindAllMoodByPatientIdByRangeDateUseCase {

    private final MoodTrackerRepositoryPort moodTrackerRepositoryPort;

    public FindAllMoodByPatientIdByRangeDateUseCaseImpl(MoodTrackerRepositoryPort moodTrackerRepositoryPort) {
        this.moodTrackerRepositoryPort = moodTrackerRepositoryPort;
    }

    @Override
    public List<MoodTracker> FindAllMoodByPatientIdByRangeDate(Long patientId, LocalDate fromDate, LocalDate toDate) {
        return moodTrackerRepositoryPort.findAllByPatientIdByRangeDate(patientId, fromDate, toDate);
    }
}
