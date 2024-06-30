package ar.edu.unlam.nuralign.application.usecases.patient;

import ar.edu.unlam.nuralign.application.ports.in.patient.FindAllPatientsByTherapistIdUseCase;
import ar.edu.unlam.nuralign.application.ports.out.PatientRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.Patient;

import java.util.List;

public class FindAllPatientsByTherapistIdUseCaseImpl implements FindAllPatientsByTherapistIdUseCase {
    private final PatientRepositoryPort patientRepositoryPort;

    public FindAllPatientsByTherapistIdUseCaseImpl(PatientRepositoryPort patientRepositoryPort) {
        this.patientRepositoryPort = patientRepositoryPort;
    }

    @Override
    public List<Patient> findAllPatientsByTherapistId(Long therapistId) {
        return patientRepositoryPort.findAllByTherapistId(therapistId);
    }
}
