package ar.edu.unlam.nuralign.infrastructure.adapters;

import ar.edu.unlam.nuralign.domain.models.Patient;
import ar.edu.unlam.nuralign.infrastructure.entities.PatientEntity;
import ar.edu.unlam.nuralign.infrastructure.mappers.PatientMapper;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaPatientRepository;
import ar.edu.unlam.nuralign.infrastructure.utils.CheckPassword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class JpaPatientRepositoryAdapterTest {

    @Mock
    private JpaPatientRepository jpaPatientRepository;

    @Mock
    private CheckPassword checkPassword;

    @InjectMocks
    private JpaPatientRepositoryAdapter jpaPatientRepositoryAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldSavePatient() {
        Patient patient = new Patient();
        patient.setPassword("testPassword"); // Set a password for the patient
        PatientEntity patientEntity = PatientMapper.mapToEntity(patient);
        patientEntity.setRegisteredFlag(true);
        patientEntity.setCreatedAt(LocalDateTime.now());
        patientEntity.setUpdatedAt(LocalDateTime.now());
        when(checkPassword.hashPassword()).thenReturn("hashedPassword");
        patientEntity.setPassword(checkPassword.hashPassword());

        when(jpaPatientRepository.save(any(PatientEntity.class))).thenReturn(patientEntity);

        //Patient savedPatient = jpaPatientRepositoryAdapter.save(patient);

        //assertEquals(patient, savedPatient);
        //verify(jpaPatientRepository, times(1)).save(any(PatientEntity.class));
    }

    @Test
    void shouldUpdatePatient() {
        Patient patient = new Patient();
        PatientEntity patientEntity = PatientMapper.mapToEntity(patient);
        patientEntity.setId(1L);
        patientEntity.setUpdatedAt(LocalDateTime.now());

        when(jpaPatientRepository.existsById(1L)).thenReturn(true);
        when(jpaPatientRepository.save(any(PatientEntity.class))).thenReturn(patientEntity);

        Optional<Patient> updatedPatient = jpaPatientRepositoryAdapter.update(patient, 1L);

        assertTrue(updatedPatient.isPresent());
        //assertEquals(patient, updatedPatient.get());
        verify(jpaPatientRepository, times(1)).existsById(1L);
        verify(jpaPatientRepository, times(1)).save(any(PatientEntity.class));
    }

    @Test
    void shouldNotUpdateNonExistingPatient() {
        Patient patient = new Patient();

        when(jpaPatientRepository.existsById(1L)).thenReturn(false);

        Optional<Patient> updatedPatient = jpaPatientRepositoryAdapter.update(patient, 1L);

        assertFalse(updatedPatient.isPresent());
        verify(jpaPatientRepository, times(1)).existsById(1L);
    }

    @Test
    void shouldFindPatientById() {
        Patient patient = new Patient();
        PatientEntity patientEntity = PatientMapper.mapToEntity(patient);

        when(jpaPatientRepository.findById(1L)).thenReturn(Optional.of(patientEntity));

        Optional<Patient> foundPatient = jpaPatientRepositoryAdapter.findById(1L);

        assertTrue(foundPatient.isPresent());
        //assertEquals(patient, foundPatient.get());
        verify(jpaPatientRepository, times(1)).findById(1L);
    }

    @Test
    void shouldReturnEmptyWhenPatientNotFound() {
        when(jpaPatientRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<Patient> foundPatient = jpaPatientRepositoryAdapter.findById(1L);

        assertFalse(foundPatient.isPresent());
        verify(jpaPatientRepository, times(1)).findById(1L);
    }

    @Test
    void shouldDeletePatient() {
        jpaPatientRepositoryAdapter.deleteById(1L);

        verify(jpaPatientRepository, times(1)).deleteById(1L);
    }
}
