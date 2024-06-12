package ar.edu.unlam.nuralign.application.usecases.patientTherapist;

import ar.edu.unlam.nuralign.application.ports.in.patientTherapist.AssignPatientToTherapistUseCase;
import ar.edu.unlam.nuralign.application.ports.out.PatientTherapistRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.PatientTherapist;

public class AssignPatientToTherapistUseCaseImpl implements AssignPatientToTherapistUseCase {
    private final PatientTherapistRepositoryPort patientTherapistRepositoryPort;

    public AssignPatientToTherapistUseCaseImpl(PatientTherapistRepositoryPort patientTherapistRepositoryPort) {
        this.patientTherapistRepositoryPort = patientTherapistRepositoryPort;
    }

    @Override
    public PatientTherapist assignPatientToTherapist(PatientTherapist patientTherapist) {
        return patientTherapistRepositoryPort.assignPatientToTherapist(patientTherapist);
    }

}
