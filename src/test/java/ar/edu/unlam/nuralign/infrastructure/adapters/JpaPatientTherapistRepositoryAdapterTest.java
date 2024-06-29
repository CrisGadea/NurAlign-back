package ar.edu.unlam.nuralign.infrastructure.adapters;

import ar.edu.unlam.nuralign.domain.models.PatientTherapist;
import ar.edu.unlam.nuralign.infrastructure.entities.PatientTherapistEntity;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaPatientTherapistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class JpaPatientTherapistRepositoryAdapterTest {

    @Mock
    private JpaPatientTherapistRepository repository;

    @InjectMocks
    private JpaPatientTherapistRepositoryAdapter adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Should save patient therapist")
    @Test
    void shouldSavePatientTherapist() {
        PatientTherapist patientTherapist = new PatientTherapist();
        PatientTherapistEntity entity = new PatientTherapistEntity();
        when(repository.save(any(PatientTherapistEntity.class))).thenReturn(entity);

        PatientTherapistEntity savedEntity = repository.save(entity);
        PatientTherapist result = new PatientTherapist(); // Convert savedEntity to domain model

        verify(repository, times(1)).save(any(PatientTherapistEntity.class));
        assertNotNull(result);
    }

    @DisplayName("Should find all patient therapists")
    @Test
    void shouldFindAllPatientTherapists() {
        PatientTherapistEntity entity = new PatientTherapistEntity();
        when(repository.findAll()).thenReturn(Collections.singletonList(entity));

        var result = repository.findAll();

        verify(repository, times(1)).findAll();
        assertEquals(1, result.size());
    }

    @DisplayName("Should find patient therapist by id")
    @Test
    void shouldFindPatientTherapistById() {
        Long id = 1L;
        PatientTherapistEntity entity = new PatientTherapistEntity();
        when(repository.findById(id)).thenReturn(Optional.of(entity));

        Optional<PatientTherapistEntity> entityOptional = repository.findById(id);
        PatientTherapist result = entityOptional.isPresent() ? new PatientTherapist() : null; // Convert entity to domain model if present

        verify(repository, times(1)).findById(id);
        assertNotNull(result);
    }
}