package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.patient.*;
import ar.edu.unlam.nuralign.domain.models.Patient;

import java.util.List;
import java.util.Optional;

public class PatientService implements CreatePatientUseCase, FindPatientUseCase, FindAllPatientsUseCase,
        DeletePatientUseCase, UpdatePatientUseCase {

    private final CreatePatientUseCase createPatientUseCase;
    private final FindPatientUseCase findPatientUseCase;
    private final FindAllPatientsUseCase findAllPatientsUseCase;
    private final DeletePatientUseCase deletePatientUseCase;
    private final UpdatePatientUseCase updatePatientUseCase;

    public PatientService(CreatePatientUseCase createPatientUseCase, FindPatientUseCase findPatientUseCase,
                          FindAllPatientsUseCase findAllPatientsUseCase, DeletePatientUseCase deletePatientUseCase,
                          UpdatePatientUseCase updatePatientUseCase) {
        this.createPatientUseCase = createPatientUseCase;
        this.findPatientUseCase = findPatientUseCase;
        this.findAllPatientsUseCase = findAllPatientsUseCase;
        this.deletePatientUseCase = deletePatientUseCase;
        this.updatePatientUseCase = updatePatientUseCase;
    }

    @Override
    public Patient createPatient(Patient patient) {
        return createPatientUseCase.createPatient(patient);
    }

    @Override
    public Optional<Patient> findPatient(Long id) {
        return findPatientUseCase.findPatient(id);
    }

    @Override
    public List<Patient> findAllPatients() {
        return findAllPatientsUseCase.findAllPatients();
    }


    @Override
    public Optional<Patient> updatePatient(Patient patient, Long patientId) {
        return updatePatientUseCase.updatePatient(patient, patientId);
    }

    @Override
    public boolean deletePatient(Long id) {
        return deletePatientUseCase.deletePatient(id);
    }
}
