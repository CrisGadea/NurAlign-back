package ar.edu.unlam.nuralign.application.ports.out;

import ar.edu.unlam.nuralign.domain.models.PatientTherapist;

import java.util.List;

public interface PatientTherapistRepositoryPort {
    void deletePatientTherapistAssignation(Long patientId, Long therapistId);
    List<PatientTherapist> findAllPatientTherapistAssignations(Long patientId);
    PatientTherapist assignPatientToTherapist(PatientTherapist patientTherapist);
}
