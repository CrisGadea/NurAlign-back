package ar.edu.unlam.nuralign.application.ports.out;

import ar.edu.unlam.nuralign.domain.models.PatientTherapist;

import java.util.List;

public interface PatientTherapistRepositoryPort {
    void deletePatientTherapistAssignation(Long id);
    List<PatientTherapist> findAllPatientTherapistAssignations();
    PatientTherapist assignPatientToTherapist(PatientTherapist patientTherapist);
}
