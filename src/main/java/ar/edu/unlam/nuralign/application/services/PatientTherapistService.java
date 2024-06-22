package ar.edu.unlam.nuralign.application.services;


import ar.edu.unlam.nuralign.application.ports.in.patientTherapist.AssignPatientToTherapistUseCase;
import ar.edu.unlam.nuralign.application.ports.in.patientTherapist.DeletePatientTherapistAssignationUseCase;
import ar.edu.unlam.nuralign.application.ports.in.patientTherapist.FindAllPatientTherapistAssignationsUseCase;
import ar.edu.unlam.nuralign.domain.models.PatientTherapist;

import java.util.List;

public class PatientTherapistService implements AssignPatientToTherapistUseCase, FindAllPatientTherapistAssignationsUseCase,
        DeletePatientTherapistAssignationUseCase {

    private final AssignPatientToTherapistUseCase assignPatientToTherapistUseCase;
    private final FindAllPatientTherapistAssignationsUseCase findAllPatientTherapistAssignationsUseCase;
    private final DeletePatientTherapistAssignationUseCase deletePatientTherapistAssignationUseCase;

    public PatientTherapistService(AssignPatientToTherapistUseCase assignPatientToTherapistUseCase,
                                   FindAllPatientTherapistAssignationsUseCase findAllPatientTherapistAssignationsUseCase,
                                   DeletePatientTherapistAssignationUseCase deletePatientTherapistAssignationUseCase) {
        this.assignPatientToTherapistUseCase = assignPatientToTherapistUseCase;
        this.findAllPatientTherapistAssignationsUseCase = findAllPatientTherapistAssignationsUseCase;
        this.deletePatientTherapistAssignationUseCase = deletePatientTherapistAssignationUseCase;
    }

    @Override
    public void deletePatientTherapistAssignation(Long patientId, Long therapistId) {
        deletePatientTherapistAssignationUseCase.deletePatientTherapistAssignation(patientId, therapistId);
    }

    @Override
    public PatientTherapist assignPatientToTherapist(PatientTherapist patientTherapist) {
        return assignPatientToTherapistUseCase.assignPatientToTherapist(patientTherapist);
    }

    @Override
    public List<PatientTherapist> findAllPatientTherapistAssignations(Long patientId) {
        return findAllPatientTherapistAssignationsUseCase.findAllPatientTherapistAssignations(patientId);
    }

}
