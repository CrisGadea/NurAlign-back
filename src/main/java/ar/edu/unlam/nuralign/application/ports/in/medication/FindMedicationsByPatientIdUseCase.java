package ar.edu.unlam.nuralign.application.ports.in.medication;

import ar.edu.unlam.nuralign.domain.models.Medication;

import java.util.List;

public interface FindMedicationsByPatientIdUseCase {
    List<Medication> findMedicationsByPatientId(Long patientId);
}
