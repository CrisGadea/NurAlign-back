package ar.edu.unlam.nuralign.infrastructure.adapters;

import ar.edu.unlam.nuralign.domain.models.Medication;
import ar.edu.unlam.nuralign.infrastructure.entities.MedicationEntity;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaMedicationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class JpaMedicationRepositoryAdapterTest {

    @Mock
    private JpaMedicationRepository repository;

    @InjectMocks
    private JpaMedicationRepositoryAdapter adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Should save medication")
    @Test
    void shouldSaveMedication() {
        Medication medication = new Medication();
        MedicationEntity entity = new MedicationEntity();
        when(repository.save(any(MedicationEntity.class))).thenReturn(entity);

        adapter.save(medication);

        verify(repository, times(1)).save(any(MedicationEntity.class));
    }

    @DisplayName("Should find medication by id")
    @Test
    void shouldFindMedicationById() {
        Long id = 1L;
        MedicationEntity entity = new MedicationEntity();
        when(repository.findById(id)).thenReturn(Optional.of(entity));

        adapter.findById(id);

        verify(repository, times(1)).findById(id);
    }

    @DisplayName("Should not find medication by id")
    @Test
    void shouldNotFindMedicationById() {
        Long id = 1L;
        when(repository.findById(id)).thenReturn(Optional.empty());

        Medication result = adapter.findById(id);

        verify(repository, times(1)).findById(id);
        assertNull(result);
    }

    @DisplayName("Should update medication")
    @Test
    void shouldUpdateMedication() {
        Long patientId = 1L;
        Medication medication = new Medication();
        MedicationEntity entity = new MedicationEntity();
        when(repository.findByPatientIdAndMedicationId(patientId, medication.getId())).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);

        adapter.updateMedication(medication, patientId);

        verify(repository, times(1)).findByPatientIdAndMedicationId(patientId, medication.getId());
        verify(repository, times(1)).save(entity);
    }

    @DisplayName("Should not update medication")
    @Test
    void shouldNotUpdateMedication() {
        Long patientId = 1L;
        Medication medication = new Medication();
        when(repository.findByPatientIdAndMedicationId(patientId, medication.getId())).thenReturn(null);

        Optional<Medication> result = adapter.updateMedication(medication, patientId);

        verify(repository, times(1)).findByPatientIdAndMedicationId(patientId, medication.getId());
        assertEquals(Optional.empty(), result);
    }

}
