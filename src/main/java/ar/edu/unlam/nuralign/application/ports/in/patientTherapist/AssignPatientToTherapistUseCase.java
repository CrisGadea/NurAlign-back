package ar.edu.unlam.nuralign.application.ports.in.patientTherapist;

import ar.edu.unlam.nuralign.domain.models.PatientTherapist;

public interface AssignPatientToTherapistUseCase {
    PatientTherapist assignPatientToTherapist(PatientTherapist patientTherapist);
}
