package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.domain.models.Therapist;
import ar.edu.unlam.nuralign.infrastructure.entities.TherapistEntity;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaTherapistRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.EmptyResultDataAccessException;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TherapistServiceTest {
    @Autowired
    private TherapistService therapistService;

    @MockBean
    private JpaTherapistRepository therapistRepository;

   /* @Test
    void shouldAddTherapistSuccessfully() {
        Therapist therapist = new Therapist();
        TherapistEntity therapistEntity = new TherapistEntity();
        when(therapistRepository.save(any(TherapistEntity.class))).thenReturn(therapistEntity);

        Therapist addedTherapist = therapistService.createTherapist(therapist);

        assertNotNull(addedTherapist);
        assertEquals(therapist.getName(), addedTherapist.getName());
    }

    @Test
    void shouldThrowExceptionWhenAddingNullTherapist() {
        assertThrows(IllegalArgumentException.class, () -> therapistService.createTherapist(null));
    }

    @Test
    void shouldGetTherapistByIdSuccessfully() {
        Therapist therapist = new Therapist();
        TherapistEntity therapistEntity = new TherapistEntity();
        when(therapistRepository.findById(anyLong())).thenReturn(Optional.of(therapistEntity));

        Therapist foundTherapist = therapistService.findTherapist(1L).get();

        assertNotNull(foundTherapist);
        assertEquals(therapist.getName(), foundTherapist.getName());
    }

    @Test
    void shouldThrowExceptionWhenTherapistNotFound() {
        when(therapistRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(UserPrincipalNotFoundException.class, () -> therapistService.findTherapist(1L));
    }

    @Test
    void shouldRemoveTherapistSuccessfully() {
        doNothing().when(therapistRepository).deleteById(anyLong());

        assertDoesNotThrow(() -> therapistService.deleteTherapist(1L));
    }

    @Test
    void shouldThrowExceptionWhenRemovingNonExistentTherapist() {
        doThrow(new EmptyResultDataAccessException(1)).when(therapistRepository).deleteById(anyLong());

        assertThrows(UserPrincipalNotFoundException.class, () -> therapistService.deleteTherapist(1L));
    }*/
}
