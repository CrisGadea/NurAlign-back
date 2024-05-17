package ar.edu.unlam.nuralign.application.ports.in.patient;

import ar.edu.unlam.nuralign.domain.models.Patient;

import java.util.List;

public interface FindAllPatientsUseCase {
    List<Patient> findAllPatients();
}
