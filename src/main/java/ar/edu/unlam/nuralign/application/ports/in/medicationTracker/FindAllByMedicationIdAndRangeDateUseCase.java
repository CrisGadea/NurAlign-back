package ar.edu.unlam.nuralign.application.ports.in.medicationTracker;

import ar.edu.unlam.nuralign.domain.models.MedicationTracker;
import ar.edu.unlam.nuralign.infrastructure.entities.MedicationTrackerEntity;

import java.time.LocalDate;
import java.util.List;

public interface FindAllByMedicationIdAndRangeDateUseCase {


    List<MedicationTracker>findAllByMedicationIdAndRangeDate(Long patientId, LocalDate fromDate, LocalDate toDate);
}
