package ar.edu.unlam.nuralign.application.ports.in.medication;

import ar.edu.unlam.nuralign.domain.models.Medication;

public interface FindMedicationUseCase {
    Medication findMedication(Long id);
}
