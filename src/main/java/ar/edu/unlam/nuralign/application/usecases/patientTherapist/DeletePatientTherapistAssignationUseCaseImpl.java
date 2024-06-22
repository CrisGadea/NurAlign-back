package ar.edu.unlam.nuralign.application.usecases.patientTherapist;

import ar.edu.unlam.nuralign.application.ports.in.patientTherapist.DeletePatientTherapistAssignationUseCase;
import ar.edu.unlam.nuralign.application.ports.out.PatientTherapistRepositoryPort;

public class DeletePatientTherapistAssignationUseCaseImpl implements DeletePatientTherapistAssignationUseCase {
    private final PatientTherapistRepositoryPort patientTherapistRepositoryPort;

    public DeletePatientTherapistAssignationUseCaseImpl(PatientTherapistRepositoryPort patientTherapistRepositoryPort) {
        this.patientTherapistRepositoryPort = patientTherapistRepositoryPort;
    }

    @Override
    public void deletePatientTherapistAssignation(Long patientId, Long therapistId) {
        patientTherapistRepositoryPort.deletePatientTherapistAssignation(patientId, therapistId);
    }
}
