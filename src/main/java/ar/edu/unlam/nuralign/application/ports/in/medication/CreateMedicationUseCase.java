package ar.edu.unlam.nuralign.application.ports.in.medication;

import ar.edu.unlam.nuralign.domain.models.Medication;

public interface CreateMedicationUseCase {
    Medication createMedication(Medication medication);
}
