package ar.edu.unlam.nuralign.infrastructure.adapters;

import ar.edu.unlam.nuralign.domain.models.Therapist;
import ar.edu.unlam.nuralign.infrastructure.entities.TherapistEntity;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaTherapistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class JpaTherapistRepositoryAdapterTest {
    @Mock
    private JpaTherapistRepository repository;

    @InjectMocks
    private JpaTherapistRepositoryAdapter adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Should save therapist")
    @Test
    void shouldSaveTherapist() {
        Therapist therapist = new Therapist();
        TherapistEntity entity = new TherapistEntity();
        when(repository.save(any(TherapistEntity.class))).thenReturn(entity);

        Therapist result = adapter.save(therapist);

        verify(repository, times(1)).save(any(TherapistEntity.class));
        assertNotNull(result);
    }

    @DisplayName("Should not update therapist when not exists")
    @Test
    void shouldNotUpdateTherapistWhenNotExists() {
        Long id = 1L;
        Therapist therapist = new Therapist();
        when(repository.existsById(id)).thenReturn(false);

        Optional<Therapist> result = adapter.update(therapist, id);

        verify(repository, times(1)).existsById(id);
        assertFalse(result.isPresent());
    }

    @DisplayName("Should find therapist by id")
    @Test
    void shouldFindTherapistById() {
        Long id = 1L;
        TherapistEntity entity = new TherapistEntity();
        when(repository.findById(id)).thenReturn(Optional.of(entity));

        Optional<Therapist> result = adapter.findById(id);

        verify(repository, times(1)).findById(id);
        assertTrue(result.isPresent());
    }

    @DisplayName("Should find all therapists")
    @Test
    void shouldFindAllTherapists() {
        TherapistEntity entity = new TherapistEntity();
        when(repository.findAll()).thenReturn(Collections.singletonList(entity));

        var result = adapter.findAll();

        verify(repository, times(1)).findAll();
        assertEquals(1, result.size());
    }
}
