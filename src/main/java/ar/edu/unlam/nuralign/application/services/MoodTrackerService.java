package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.moodTracker.*;
import ar.edu.unlam.nuralign.domain.models.MoodTracker;
import ar.edu.unlam.nuralign.infrastructure.dtos.MoodTrackerDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class MoodTrackerService implements CreateMoodTrackerUseCase, FindMoodTrackerUseCase, FindAllMoodTrackersUseCase,
        FindMoodTrackerByPatientIdAndEffectiveDateUseCase, UpdateMoodTrackerUseCase {

        private final CreateMoodTrackerUseCase createMoodTrackerUseCase;
        private final FindMoodTrackerUseCase findMoodTrackerUseCase;
        private final FindAllMoodTrackersUseCase findAllMoodTrackersUseCase;
        private final FindMoodTrackerByPatientIdAndEffectiveDateUseCase findAllByPatientIdAndEffectiveDateUseCase;
        private final UpdateMoodTrackerUseCase updateMoodTrackerUseCase;
        private final FindAllMoodTrackersByPatientIdUseCase findAllByPatientIdUseCase;
        private final FindAllMoodByPatientIdByRangeDateUseCase findAllMoodByPatientIdByRangeDateUseCase;

        public MoodTrackerService(CreateMoodTrackerUseCase createMoodTrackerUseCase,
                                  FindMoodTrackerUseCase findMoodTrackerUseCase,
                                  FindAllMoodTrackersUseCase findAllMoodTrackersUseCase,
                                  FindMoodTrackerByPatientIdAndEffectiveDateUseCase findAllByPatientIdAndEffectiveDateUseCase,
                                  UpdateMoodTrackerUseCase updateMoodTrackerUseCase, FindAllMoodTrackersByPatientIdUseCase findAllByPatientIdUseCase, FindAllMoodByPatientIdByRangeDateUseCase findAllMoodByPatientIdByRangeDateUseCase) {
            this.createMoodTrackerUseCase = createMoodTrackerUseCase;
            this.findMoodTrackerUseCase = findMoodTrackerUseCase;
            this.findAllMoodTrackersUseCase = findAllMoodTrackersUseCase;
            this.findAllByPatientIdAndEffectiveDateUseCase = findAllByPatientIdAndEffectiveDateUseCase;
            this.updateMoodTrackerUseCase = updateMoodTrackerUseCase;
            this.findAllByPatientIdUseCase = findAllByPatientIdUseCase;
            this.findAllMoodByPatientIdByRangeDateUseCase = findAllMoodByPatientIdByRangeDateUseCase;
        }

        @Override
        public MoodTracker createMoodTracker(MoodTrackerDto moodTracker){
            return createMoodTrackerUseCase.createMoodTracker(moodTracker);
        }

        @Override
        public MoodTracker findMoodTracker(Long id) {
            return findMoodTrackerUseCase.findMoodTracker(id);
        }
        public List<MoodTracker> findAllMoodTrackersByPatientId(Long patientId)
        {

        return findAllByPatientIdUseCase.findAllMoodTrackersByPatientId(patientId);
         }

        @Override
        public List<MoodTracker> findAllMoodTrackers() {
            return findAllMoodTrackersUseCase.findAllMoodTrackers();
        }

        @Override
        public Optional<MoodTracker> findMoodTrackerByPatientIdAndEffectiveDate(Long patientId, String effectiveDate) {
            return findAllByPatientIdAndEffectiveDateUseCase.findMoodTrackerByPatientIdAndEffectiveDate(patientId, effectiveDate);
        }

        @Override
        public Optional<MoodTracker> updateMoodTracker(MoodTracker moodTracker, Long patientId, String effectiveDate) {
            return updateMoodTrackerUseCase.updateMoodTracker(moodTracker, patientId, effectiveDate);
        }

        public List<MoodTracker>FindAllMoodByPatientIdByRangeDate(Long patientId, LocalDate fromDate, LocalDate toDate)
        {
            return findAllMoodByPatientIdByRangeDateUseCase.FindAllMoodByPatientIdByRangeDate(patientId, fromDate, toDate);
        }
}
