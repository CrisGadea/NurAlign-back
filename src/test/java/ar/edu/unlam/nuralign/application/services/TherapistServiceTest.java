package ar.edu.unlam.nuralign.application.services;import ar.edu.unlam.nuralign.application.ports.in.therapist.*;
import ar.edu.unlam.nuralign.domain.models.Therapist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class TherapistServiceTest {
    @Mock
    private CreateTherapistUseCase createTherapistUseCase;

    @Mock
    private UpdateTherapistUseCase updateTherapistUseCase;

    @Mock
    private DeleteTherapistUseCase deleteTherapistUseCase;

    @Mock
    private FindTherapistUseCase findTherapistUseCase;

    @Mock
    private FindAllTherapistsUseCase findAllTherapistsUseCase;

    @InjectMocks
    private TherapistService therapistService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateTherapist() {
        Therapist therapist = new Therapist();
        when(createTherapistUseCase.createTherapist(therapist)).thenReturn(therapist);

        Therapist result = therapistService.createTherapist(therapist);

        assertEquals(therapist, result);
        verify(createTherapistUseCase, times(1)).createTherapist(therapist);
    }

    @Test
    public void testDeleteTherapist() {
        Long id = 1L;
        when(deleteTherapistUseCase.deleteTherapist(id)).thenReturn(true);

        boolean result = therapistService.deleteTherapist(id);

        assertTrue(result);
        verify(deleteTherapistUseCase, times(1)).deleteTherapist(id);
    }

    @Test
    public void testFindAllTherapists() {
        List<Therapist> therapists = Arrays.asList(new Therapist(), new Therapist());
        when(findAllTherapistsUseCase.findAllTherapists()).thenReturn(therapists);

        List<Therapist> result = therapistService.findAllTherapists();

        assertEquals(therapists, result);
        verify(findAllTherapistsUseCase, times(1)).findAllTherapists();
    }

    @Test
    public void testFindTherapist() {
        Long id = 1L;
        Therapist therapist = new Therapist();
        when(findTherapistUseCase.findTherapist(id)).thenReturn(Optional.of(therapist));

        Optional<Therapist> result = therapistService.findTherapist(id);

        assertTrue(result.isPresent());
        assertEquals(therapist, result.get());
        verify(findTherapistUseCase, times(1)).findTherapist(id);
    }

    @Test
    public void testUpdateTherapist() {
        Long id = 1L;
        Therapist therapist = new Therapist();
        when(updateTherapistUseCase.updateTherapist(therapist, id)).thenReturn(Optional.of(therapist));

        Optional<Therapist> result = therapistService.updateTherapist(therapist, id);

        assertTrue(result.isPresent());
        assertEquals(therapist, result.get());
        verify(updateTherapistUseCase, times(1)).updateTherapist(therapist, id);
    }
}
