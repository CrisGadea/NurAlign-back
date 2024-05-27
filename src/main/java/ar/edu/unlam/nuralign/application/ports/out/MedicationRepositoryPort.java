package ar.edu.unlam.nuralign.application.ports.out;

import ar.edu.unlam.nuralign.domain.models.Medication;

import java.util.List;

public interface MedicationRepositoryPort {
    Medication save(Medication medication);
    List<Medication> findAll();
    Medication findById(Long id);
    List<Medication> findAllByPatientId(Long patientId);
}
