package ar.edu.unlam.nuralign.application.ports.out;

import ar.edu.unlam.nuralign.domain.models.MedicationTracker;

import java.time.LocalDate;
import java.util.List;

public interface MedicationTrackerRepositoryPort {
    MedicationTracker save(MedicationTracker medication);
    List<MedicationTracker> findAll();
    MedicationTracker findById(Long id);
    List<MedicationTracker> findAllByPatientId(Long patientId);
    List<MedicationTracker> findAllByEffectiveDate(LocalDate effectiveDate);
    List<MedicationTracker> findAllByPatientIdAndEffectiveDate(Long patientId, LocalDate effectiveDate);
}