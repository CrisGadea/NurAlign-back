package ar.edu.unlam.nuralign.application.ports.out;

import ar.edu.unlam.nuralign.domain.models.Medication;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MedicationRepositoryPort {
    Medication save(Medication medication);
    List<Medication> findAll();
    Medication findById(Long id);
    List<Medication> findAllByPatientId(Long patientId);
    Optional<Medication> updateMedication(Medication medication, Long patientId);
    void deleteMedication(Long id);
    List<Medication> findAllMedicationByPatientId(Long patientId, LocalDate fromDate, LocalDate toDate);
}
