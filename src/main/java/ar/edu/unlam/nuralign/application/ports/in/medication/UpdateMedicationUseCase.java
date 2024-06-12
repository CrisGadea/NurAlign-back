package ar.edu.unlam.nuralign.application.ports.in.medication;

import ar.edu.unlam.nuralign.domain.models.Medication;

import java.util.Optional;

public interface UpdateMedicationUseCase {
    Optional<Medication> updateMedication(Medication medication, Long patientId);
}
