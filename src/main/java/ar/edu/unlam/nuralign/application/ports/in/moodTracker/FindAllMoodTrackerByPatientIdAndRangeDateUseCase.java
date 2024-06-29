package ar.edu.unlam.nuralign.application.ports.in.moodTracker;

import ar.edu.unlam.nuralign.domain.models.MoodTracker;

import java.time.LocalDate;
import java.util.List;

public interface FindAllMoodTrackerByPatientIdAndRangeDateUseCase {

    List<MoodTracker>  FindAllMoodByPatientIdByRangeDate(Long patientId, LocalDate fromDate, LocalDate toDate);
}
