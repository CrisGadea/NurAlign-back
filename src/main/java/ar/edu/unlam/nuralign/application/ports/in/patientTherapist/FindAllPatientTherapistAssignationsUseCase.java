package ar.edu.unlam.nuralign.application.ports.in.patientTherapist;

import ar.edu.unlam.nuralign.domain.models.PatientTherapist;

import java.util.List;

public interface FindAllPatientTherapistAssignationsUseCase {
    List<PatientTherapist> findAllPatientTherapistAssignations(Long patientId);
}
