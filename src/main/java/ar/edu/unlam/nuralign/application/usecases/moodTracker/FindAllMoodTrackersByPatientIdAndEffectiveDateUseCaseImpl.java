package ar.edu.unlam.nuralign.application.usecases.moodTracker;

import ar.edu.unlam.nuralign.application.ports.in.moodTracker.FindAllMoodTrackersByPatientIdAndEffectiveDateUseCase;
import ar.edu.unlam.nuralign.application.ports.out.MoodTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.MoodTracker;

import java.time.LocalDate;
import java.util.List;

public class FindAllMoodTrackersByPatientIdAndEffectiveDateUseCaseImpl implements FindAllMoodTrackersByPatientIdAndEffectiveDateUseCase {
    private final MoodTrackerRepositoryPort moodTrackerRepository;

    public FindAllMoodTrackersByPatientIdAndEffectiveDateUseCaseImpl(MoodTrackerRepositoryPort moodTrackerRepository) {
        this.moodTrackerRepository = moodTrackerRepository;
    }

    @Override
    public List<MoodTracker> findAllMoodTrackersByPatientIdAndEffectiveDate(Long patientId, String effectiveDate) {
        return moodTrackerRepository.findAllByPatientIdAndEffectiveDate(patientId, LocalDate.parse(effectiveDate));
    }
}
