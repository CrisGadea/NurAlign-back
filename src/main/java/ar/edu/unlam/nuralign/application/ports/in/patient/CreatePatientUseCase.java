package ar.edu.unlam.nuralign.application.ports.in.patient;

import ar.edu.unlam.nuralign.domain.models.Patient;

public interface CreatePatientUseCase {
    Patient createPatient(Patient patient);
}
