package ar.edu.unlam.nuralign.application.usecases;

import ar.edu.unlam.nuralign.application.ports.in.therapist.CreateTherapistUseCase;
import ar.edu.unlam.nuralign.application.ports.out.TherapistRepositoryPort;
import ar.edu.unlam.nuralign.application.usecases.therapist.CreateTherapistUseCaseImpl;
import ar.edu.unlam.nuralign.domain.models.Therapist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class CreateTherapistUseCaseImplTest {
    @Mock
    private TherapistRepositoryPort therapistRepositoryPort;

    private CreateTherapistUseCase createTherapistUseCase;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        createTherapistUseCase = new CreateTherapistUseCaseImpl(therapistRepositoryPort);
    }

    @Test
    @DisplayName("Should create therapist successfully")
    public void shouldCreateTherapistSuccessfully() {
        Therapist therapist = new Therapist();
        when(therapistRepositoryPort.save(therapist)).thenReturn(therapist);
        assertEquals(therapist, createTherapistUseCase.createTherapist(therapist));
    }

    @Test
    @DisplayName("Should not create therapist successfully")
    public void shouldNotCreateTherapistSuccessfully() {
        Therapist therapist = new Therapist();
        when(therapistRepositoryPort.save(therapist)).thenReturn(null);
        assertNull(createTherapistUseCase.createTherapist(therapist));
    }

}
