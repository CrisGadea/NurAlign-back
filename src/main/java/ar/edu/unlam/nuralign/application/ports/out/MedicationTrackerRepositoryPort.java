package ar.edu.unlam.nuralign.application.ports.out;

import ar.edu.unlam.nuralign.domain.models.MedicationTracker;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MedicationTrackerRepositoryPort {
    MedicationTracker save(MedicationTracker medication);
    List<MedicationTracker> findAll();
    MedicationTracker findById(Long id);
    List<MedicationTracker> findAllByPatientId(Long patientId);
    MedicationTracker findByEffectiveDate(LocalDate effectiveDate);
    MedicationTracker findByPatientIdAndEffectiveDate(Long patientId, LocalDate effectiveDate);
    Optional<MedicationTracker> update(MedicationTracker medication, Long patientId, LocalDate effectiveDate);
    List<MedicationTracker>findAllByMedicationIdAndRangeDate(Long patientId, LocalDate fromDate, LocalDate toDate);
}
