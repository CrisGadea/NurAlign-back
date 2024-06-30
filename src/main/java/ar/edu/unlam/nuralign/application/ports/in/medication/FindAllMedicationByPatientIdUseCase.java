package ar.edu.unlam.nuralign.application.ports.in.medication;

import ar.edu.unlam.nuralign.domain.models.Medication;

import java.time.LocalDate;
import java.util.List;

public interface FindAllMedicationByPatientIdUseCase {

    List <Medication> findAllMedicationByPatientId(Long patientId, LocalDate fromDate, LocalDate toDate,Character takenFlag);
}
