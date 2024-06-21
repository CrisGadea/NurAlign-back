//package ar.edu.unlam.nuralign.application.usecases.patientTherapist;
//
//import ar.edu.unlam.nuralign.application.ports.in.patientTherapist.FindAllPatientTherapistAssignationsUseCase;
//import ar.edu.unlam.nuralign.application.ports.out.PatientTherapistRepositoryPort;
//import ar.edu.unlam.nuralign.domain.models.PatientTherapist;
//
//import java.util.List;
//
//public class FindAllPatientTherapistAssignationsUseCaseImpl implements FindAllPatientTherapistAssignationsUseCase {
//    private final PatientTherapistRepositoryPort patientTherapistRepositoryPort;
//
//    public FindAllPatientTherapistAssignationsUseCaseImpl(PatientTherapistRepositoryPort patientTherapistRepositoryPort) {
//        this.patientTherapistRepositoryPort = patientTherapistRepositoryPort;
//    }
//
//    @Override
//    public List<PatientTherapist> findAllPatientTherapistAssignations() {
//        return patientTherapistRepositoryPort.findAllPatientTherapistAssignations();
//    }
//
//}
