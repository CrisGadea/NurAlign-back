package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.moodTracker.CreateMoodTrackerUseCase;
import ar.edu.unlam.nuralign.application.ports.in.moodTracker.FindAllMoodTrackersUseCase;
import ar.edu.unlam.nuralign.application.ports.in.moodTracker.FindMoodTrackerUseCase;
import ar.edu.unlam.nuralign.domain.models.MoodTracker;
import ar.edu.unlam.nuralign.infrastructure.dtos.MoodTrackerDto;

import java.util.List;

public class MoodTrackerService implements CreateMoodTrackerUseCase, FindMoodTrackerUseCase, FindAllMoodTrackersUseCase {

        private final CreateMoodTrackerUseCase createMoodTrackerUseCase;
        private final FindMoodTrackerUseCase findMoodTrackerUseCase;
        private final FindAllMoodTrackersUseCase findAllMoodTrackersUseCase;

        public MoodTrackerService(CreateMoodTrackerUseCase createMoodTrackerUseCase, FindMoodTrackerUseCase findMoodTrackerUseCase,
                                FindAllMoodTrackersUseCase findAllMoodTrackersUseCase) {
            this.createMoodTrackerUseCase = createMoodTrackerUseCase;
            this.findMoodTrackerUseCase = findMoodTrackerUseCase;
            this.findAllMoodTrackersUseCase = findAllMoodTrackersUseCase;
        }

        @Override
        public MoodTracker createMoodTracker(MoodTrackerDto moodTracker){
            return createMoodTrackerUseCase.createMoodTracker(moodTracker);
        }

        @Override
        public MoodTracker findMoodTracker(Long id) {
            return findMoodTrackerUseCase.findMoodTracker(id);
        }

        @Override
        public List<MoodTracker> findAllMoodTrackers() {
            return findAllMoodTrackersUseCase.findAllMoodTrackers();
        }
}
