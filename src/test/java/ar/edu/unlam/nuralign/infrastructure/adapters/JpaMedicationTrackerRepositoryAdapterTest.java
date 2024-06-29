package ar.edu.unlam.nuralign.infrastructure.adapters;

import ar.edu.unlam.nuralign.domain.models.MedicationTracker;
import ar.edu.unlam.nuralign.infrastructure.entities.MedicationTrackerEntity;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaMedicationTrackerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class JpaMedicationTrackerRepositoryAdapterTest {
    @Mock
    private JpaMedicationTrackerRepository repository;

    @InjectMocks
    private JpaMedicationTrackerRepositoryAdapter adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Should save medication tracker")
    @Test
    void shouldSaveMedicationTracker() {
        MedicationTracker medicationTracker = new MedicationTracker();
        MedicationTrackerEntity entity = new MedicationTrackerEntity();
        when(repository.save(any(MedicationTrackerEntity.class))).thenReturn(entity);

        MedicationTracker result = adapter.save(medicationTracker);

        verify(repository, times(1)).save(any(MedicationTrackerEntity.class));
        assertNotNull(result);
    }

    @DisplayName("Should find all medication trackers")
    @Test
    void shouldFindAllMedicationTrackers() {
        MedicationTrackerEntity entity = new MedicationTrackerEntity();
        when(repository.findAll()).thenReturn(Collections.singletonList(entity));

        var result = adapter.findAll();

        verify(repository, times(1)).findAll();
        Assertions.assertEquals(1, result.size());
    }

    @DisplayName("Should find medication tracker by id")
    @Test
    void shouldFindMedicationTrackerById() {
        Long id = 1L;
        MedicationTrackerEntity entity = new MedicationTrackerEntity();
        when(repository.findById(id)).thenReturn(Optional.of(entity));

        MedicationTracker result = adapter.findById(id);

        verify(repository, times(1)).findById(id);
        assertNotNull(result);
    }

}
