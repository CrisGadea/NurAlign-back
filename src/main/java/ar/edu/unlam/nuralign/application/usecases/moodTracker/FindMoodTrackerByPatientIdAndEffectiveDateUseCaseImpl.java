package ar.edu.unlam.nuralign.application.usecases.moodTracker;

import ar.edu.unlam.nuralign.application.ports.in.moodTracker.FindMoodTrackerByPatientIdAndEffectiveDateUseCase;
import ar.edu.unlam.nuralign.application.ports.out.MoodTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.MoodTracker;

import java.util.Optional;

public class FindMoodTrackerByPatientIdAndEffectiveDateUseCaseImpl implements FindMoodTrackerByPatientIdAndEffectiveDateUseCase {
    private final MoodTrackerRepositoryPort moodTrackerRepository;

    public FindMoodTrackerByPatientIdAndEffectiveDateUseCaseImpl(MoodTrackerRepositoryPort moodTrackerRepository) {
        this.moodTrackerRepository = moodTrackerRepository;
    }

    @Override
    public Optional<MoodTracker> findMoodTrackerByPatientIdAndEffectiveDate(Long patientId, String effectiveDate) {
        return Optional.ofNullable(moodTrackerRepository.findByPatientIdAndEffectiveDate(patientId, effectiveDate));
    }
}
